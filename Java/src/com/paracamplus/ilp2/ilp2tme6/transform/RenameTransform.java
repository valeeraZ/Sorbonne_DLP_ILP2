package com.paracamplus.ilp2.ilp2tme6.transform;

import com.paracamplus.ilp1.compiler.CompilationException;
import com.paracamplus.ilp1.compiler.normalizer.INormalizationEnvironment;
import com.paracamplus.ilp1.compiler.normalizer.NoSuchLocalVariableException;
import com.paracamplus.ilp1.interfaces.IAST;
import com.paracamplus.ilp1.interfaces.IASTblock;
import com.paracamplus.ilp1.interfaces.IASTexpression;
import com.paracamplus.ilp1.interfaces.IASTvariable;
import com.paracamplus.ilp1.interfaces.IASTblock.IASTbinding;
import com.paracamplus.ilp2.interfaces.IASTfactory;
import com.paracamplus.ilp2.interfaces.IASTfunctionDefinition;

public class RenameTransform extends CopyTransform<INormalizationEnvironment> {

    protected int nbVariable = 0;

    public RenameTransform(IASTfactory factory) {
        super(factory);
    }

    @Override
    public IAST visit(IASTblock iast, INormalizationEnvironment data) throws CompilationException{
        INormalizationEnvironment newdata = data;
        IASTbinding[] bindings = iast.getBindings();
        IASTbinding[] newbindings =
                new IASTbinding[bindings.length];

        for ( int i=0 ; i<bindings.length ; i++ ) {
            IASTbinding binding = bindings[i];

            //variable
            IASTvariable variable = binding.getVariable();
            IASTvariable newvariable = factory.newVariable(variable.getMangledName()+ "_" + nbVariable);
            //newvariable = (IASTvariable) variable.accept(this, data);

            //initialisation: accept avec l'ancien environnement
            IASTexpression newexpr = (IASTexpression) binding.getInitialisation().accept(this, data);
            newbindings[i] = factory.newBinding(newvariable, newexpr);

            newdata = newdata.extend(variable, newvariable);

            nbVariable++;
        }
        IASTexpression newbody = (IASTexpression) iast.getBody().accept(this, newdata);
        return factory.newBlock(newbindings, newbody);
    }

    @Override
    public IAST visit(IASTfunctionDefinition iast, INormalizationEnvironment data) throws CompilationException{
        //functionVariable
        IASTvariable functionVariable  =  (IASTvariable) iast.getFunctionVariable().accept(this, data);

        //variables
        IASTvariable[] variables = iast.getVariables();
        IASTvariable[] newvariables = new IASTvariable[variables.length];

        INormalizationEnvironment newdata = data;

        for ( int i=0 ; i<variables.length ; i++ ) {
            IASTvariable variable = variables[i];
            IASTvariable newvariable = factory.newVariable(variable.getMangledName() + "_" + nbVariable);
            //newvariable = (IASTvariable) variable.accept(this, data);

            newdata = newdata.extend(variable, newvariable);
            newvariables[i] = newvariable;
            nbVariable++;
        }

        //body
        IASTexpression newbody = (IASTexpression) iast.getBody().accept(this, newdata);

        return factory.newFunctionDefinition(functionVariable, newvariables, newbody);
    }

    @Override
    public IAST visit(IASTvariable iast, INormalizationEnvironment data) throws CompilationException{
        try{
            return data.renaming(iast);
        }catch(NoSuchLocalVariableException e){
            return iast;
        }
    }
}

