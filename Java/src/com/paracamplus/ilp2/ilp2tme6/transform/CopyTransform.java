package com.paracamplus.ilp2.ilp2tme6.transform;

import com.paracamplus.ilp1.compiler.CompilationException;
import com.paracamplus.ilp1.interfaces.IASTalternative;
import com.paracamplus.ilp1.interfaces.IASTbinaryOperation;
import com.paracamplus.ilp1.interfaces.IASTblock;
import com.paracamplus.ilp1.interfaces.IASTboolean;
import com.paracamplus.ilp1.interfaces.IASTexpression;
import com.paracamplus.ilp2.interfaces.IASTfactory;
import com.paracamplus.ilp1.interfaces.IASTfloat;
import com.paracamplus.ilp1.interfaces.IASTinteger;
import com.paracamplus.ilp1.interfaces.IASTinvocation;
import com.paracamplus.ilp2.interfaces.IASTprogram;
import com.paracamplus.ilp1.interfaces.IASTsequence;
import com.paracamplus.ilp1.interfaces.IASTstring;
import com.paracamplus.ilp1.interfaces.IASTunaryOperation;
import com.paracamplus.ilp1.interfaces.IASTvariable;
import com.paracamplus.ilp2.interfaces.IASTassignment;
import com.paracamplus.ilp2.interfaces.IASTfunctionDefinition;
import com.paracamplus.ilp2.interfaces.IASTloop;
import com.paracamplus.ilp2.interfaces.IASTvisitor;
import com.paracamplus.ilp1.interfaces.IASTblock.IASTbinding;

public class CopyTransform<Data> implements IASTvisitor<IASTexpression, Data, CompilationException> {

    protected IASTfactory factory;

    public CopyTransform(IASTfactory factory) {
        this.factory = factory;
    }
    
    //point d'entrée
    public IASTprogram visit(IASTprogram iast, Data data) 
			throws CompilationException {
		IASTexpression expression = iast.getBody().accept(this, data);
		IASTfunctionDefinition[] oldfunctions = iast.getFunctionDefinitions();
		IASTfunctionDefinition[] functions = new IASTfunctionDefinition[oldfunctions.length];
		for (int i = 0; i < oldfunctions.length; i++) {
			functions[i] = visit(oldfunctions[i], data);
		}
		return factory.newProgram(functions, expression);
    }
    
    //pendant visit(IASTprogram)
    public IASTfunctionDefinition visit(IASTfunctionDefinition iast, Data data) 
			throws CompilationException {
		IASTvariable functionVariable  = (IASTvariable) iast.getFunctionVariable().accept(this,data);
		IASTvariable[] oldvariables = iast.getVariables();
		IASTvariable[] variables = new IASTvariable[oldvariables.length];
		IASTexpression body = iast.getBody().accept(this, data);
		for (int i = 0; i < oldvariables.length; i++) {
			variables[i] = (IASTvariable) oldvariables[i].accept(this,data);
		}
		return factory.newFunctionDefinition(functionVariable, variables, body);
	}
    

    @Override
    public IASTexpression visit(IASTalternative iast, Data data) throws CompilationException {
        return factory.newAlternative(
                iast.getCondition().accept(this,data),
                iast.getConsequence().accept(this,data),
                iast.isTernary() ? iast.getAlternant().accept(this,data) : null);

    }

    @Override
    public IASTexpression visit(IASTbinaryOperation iast, Data data) throws CompilationException {
        return factory.newBinaryOperation(
                iast.getOperator(),
                iast.getLeftOperand().accept(this,data),
                iast.getRightOperand().accept(this,data));
    }

    @Override
    public IASTexpression visit(IASTblock iast, Data data) throws CompilationException {
        int length = iast.getBindings().length;
        IASTbinding[] bindings = new IASTbinding[length];
        for(int i = 0; i < length; i++){
            bindings[i] = factory.newBinding(
                    iast.getBindings()[i].getVariable(),
                    iast.getBindings()[i].getInitialisation().accept(this,data));
        }
        return factory.newBlock(
                bindings,
                iast.getBody().accept(this,data));
    }

    @Override
    public IASTexpression visit(IASTboolean iast, Data data) throws CompilationException {
        return factory.newBooleanConstant(iast.getValue().toString());
    }

    @Override
    public IASTexpression visit(IASTfloat iast, Data data) throws CompilationException {
        return factory.newFloatConstant(iast.getValue().toString());
    }

    @Override
    public IASTexpression visit(IASTinteger iast, Data data) throws CompilationException {
        return factory.newIntegerConstant(iast.getValue().toString());
    }

    @Override
    public IASTexpression visit(IASTinvocation iast, Data data) throws CompilationException {
        int length = iast.getArguments().length;
        IASTexpression[] arguments = new IASTexpression[length];
        for(int i = 0; i < length; i++){
            arguments[i] = iast.getArguments()[i].accept(this,data);
        }

        return factory.newInvocation(
                iast.getFunction().accept(this,data),
                arguments);
    }

    @Override
    public IASTexpression visit(IASTsequence iast, Data data) throws CompilationException {
        int length = iast.getExpressions().length;
        IASTexpression[] instructions = new IASTexpression[length];
        for(int i = 0; i < length; i++){
            instructions[i] = iast.getExpressions()[i].accept(this,data);
        }
        return factory.newSequence(instructions);
    }

    @Override
    public IASTexpression visit(IASTstring iast, Data data) throws CompilationException {
        return factory.newStringConstant(iast.getValue());
    }

    @Override
    public IASTexpression visit(IASTunaryOperation iast, Data data) throws CompilationException {
        return factory.newUnaryOperation(
                iast.getOperator(),
                iast.getOperand().accept(this,data));
    }

    @Override
    public IASTexpression visit(IASTvariable iast, Data data) throws CompilationException {
        return factory.newVariable(iast.getName());
    }

    @Override
    public IASTexpression visit(IASTassignment iast, Data data) throws CompilationException {
        return factory.newAssignment(
                iast.getVariable(),
                iast.getExpression().accept(this,data));
    }

    @Override
    public IASTexpression visit(IASTloop iast, Data data) throws CompilationException {
        return factory.newLoop(
                iast.getCondition().accept(this,data),
                iast.getBody().accept(this,data));
    }

}

