package com.paracamplus.ilp2.ilp2tme6.transform;

import com.paracamplus.ilp1.compiler.CompilationException;
import com.paracamplus.ilp1.compiler.normalizer.INormalizationEnvironment;
import com.paracamplus.ilp1.interfaces.*;
import com.paracamplus.ilp1.interfaces.IASTblock.IASTbinding;
import com.paracamplus.ilp2.interfaces.IASTfactory;
import com.paracamplus.ilp2.interfaces.IASTfunctionDefinition;
import com.paracamplus.ilp2.interfaces.IASTprogram;

import java.util.HashMap;
import java.util.Map;

public class InlineTransform extends CopyTransform<INormalizationEnvironment>{

    protected RenameTransform renameTransform;
    protected CallAnalysis callAnalysis;
    protected Map<String, IASTfunctionDefinition> functionDefinitions;

    public InlineTransform(IASTfactory factory) {
        super(factory);
        renameTransform = new RenameTransform(factory);
        functionDefinitions = new HashMap<>();
    }

    @Override
    public IAST visit(IASTprogram iast, INormalizationEnvironment data) throws CompilationException {
        callAnalysis = new CallAnalysis(iast);
        iast = (IASTprogram) renameTransform.visit(iast, data);

        for(IASTfunctionDefinition f : iast.getFunctionDefinitions()){

            IASTvariable functionVariable = f.getFunctionVariable();
            String name = functionVariable.getName();
            IASTvariable[] variables = f.getVariables().clone();
            IASTexpression body = (IASTexpression) f.getBody().accept(this, data);
            IASTfunctionDefinition newFunctionDefinition = factory.newFunctionDefinition(functionVariable, variables, body);

            functionDefinitions.put(name, newFunctionDefinition);
        }
        return super.visit(iast, data);
    }

    @Override
    public IAST visit(IASTinvocation iast, INormalizationEnvironment data) throws CompilationException {
        if ( ! (iast.getFunction() instanceof IASTvariable))
            return factory.newInvocation(iast.getFunction(), iast.getArguments());

        IASTvariable variable = (IASTvariable) iast.getFunction();
        boolean isRecursive = callAnalysis.isRecursive(variable);
        boolean isDefined = functionDefinitions.containsKey(variable.getName());
        //intégration possible: non récursif et non primitive
        if(!isRecursive && isDefined){

            IASTfunctionDefinition f = functionDefinitions.get(variable.getName());
            IASTbinding[] bindings = new IASTbinding[iast.getArguments().length];

            for(int i = 0; i < iast.getArguments().length; i++){
                bindings[i] = factory.newBinding(f.getVariables()[i], (IASTexpression) iast.getArguments()[i].accept(this, data));
            }

            return factory.newBlock(bindings, f.getBody());
        }else {
            //non intégration
            return iast;
        }
    }
}
