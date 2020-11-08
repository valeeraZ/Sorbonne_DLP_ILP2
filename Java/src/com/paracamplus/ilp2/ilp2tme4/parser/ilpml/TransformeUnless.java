package com.paracamplus.ilp2.ilp2tme4.parser.ilpml;


import com.paracamplus.ilp1.ast.ASTblock;
import com.paracamplus.ilp1.interfaces.*;
import com.paracamplus.ilp2.ilp2tme4.ast.ASTfactory;
import com.paracamplus.ilp2.ilp2tme4.interfaces.IASTfactory;
import com.paracamplus.ilp2.ilp2tme4.interfaces.IASTunless;
import com.paracamplus.ilp2.ilp2tme4.interfaces.IASTvisitor;
import com.paracamplus.ilp2.interfaces.IASTassignment;
import com.paracamplus.ilp2.interfaces.IASTfunctionDefinition;
import com.paracamplus.ilp2.interfaces.IASTloop;
import com.paracamplus.ilp2.interfaces.IASTprogram;

/**
 * Méthode 2: dans une passe séparée qui transforme un AST avec unless en AST sans unless (celle-ci s’implante naturellement
 * avec un motif visiteur ).
 */
public class TransformeUnless implements IASTvisitor<IASTexpression, Void, Exception> {

    IASTfactory factory = new ASTfactory();

    public IASTprogram visit(IASTprogram iast) throws Exception {
        //importante: transformer unless dans functions (par rapport à ILP1)
        int length = iast.getFunctionDefinitions().length;
        IASTfunctionDefinition[] functions = new IASTfunctionDefinition[length];
        for(int i = 0; i < length; i++){
            functions[i] = iast.getFunctionDefinitions()[i];
        }

        return factory.newProgram(
                functions,
                iast.getBody().accept(this,null));
    }


    @Override
    public IASTexpression visit(IASTunless iast, Void data) throws Exception {
        return factory.newAlternative(
                iast.getCondition().accept(this,data),
                factory.newBooleanConstant("false"),
                iast.getBody().accept(this,data));
    }

    @Override
    public IASTexpression visit(IASTassignment iast, Void data) throws Exception {
        return factory.newAssignment(
                iast.getVariable(),
                iast.getExpression().accept(this,data));
    }

    @Override
    public IASTexpression visit(IASTloop iast, Void data) throws Exception {
        return factory.newLoop(
                iast.getCondition().accept(this,data),
                iast.getBody().accept(this,data));
    }

    @Override
    public IASTexpression visit(IASTalternative iast, Void data) throws Exception {
        return factory.newAlternative(
                iast.getCondition().accept(this,data),
                iast.getConsequence().accept(this,data),
                iast.isTernary() ? iast.getAlternant().accept(this,data) : null);
    }

    @Override
    public IASTexpression visit(IASTbinaryOperation iast, Void data) throws Exception {
        return factory.newBinaryOperation(
                iast.getOperator(),
                iast.getLeftOperand().accept(this,data),
                iast.getRightOperand().accept(this,data));
    }

    @Override
    public IASTexpression visit(IASTblock iast, Void data) throws Exception {
        int length = iast.getBindings().length;
        IASTblock.IASTbinding[] bindings = new ASTblock.ASTbinding[length];
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
    public IASTexpression visit(IASTboolean iast, Void data) throws Exception {
        return factory.newBooleanConstant(iast.getDescription());
    }

    @Override
    public IASTexpression visit(IASTfloat iast, Void data) throws Exception {
        return factory.newFloatConstant(iast.getDescription());
    }

    @Override
    public IASTexpression visit(IASTinteger iast, Void data) throws Exception {
        return factory.newIntegerConstant(iast.getDescription());
    }

    @Override
    public IASTexpression visit(IASTinvocation iast, Void data) throws Exception {
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
    public IASTexpression visit(IASTsequence iast, Void data) throws Exception {
        int length = iast.getExpressions().length;
        IASTexpression[] instructions = new IASTexpression[length];
        for(int i = 0; i < length; i++){
            instructions[i] = iast.getExpressions()[i].accept(this,data);
        }
        return factory.newSequence(instructions);
    }

    @Override
    public IASTexpression visit(IASTstring iast, Void data) throws Exception {
        return factory.newStringConstant(iast.getDescription());
    }

    @Override
    public IASTexpression visit(IASTunaryOperation iast, Void data) throws Exception {
        return factory.newUnaryOperation(
                iast.getOperator(),
                iast.getOperand().accept(this,data));
    }

    @Override
    public IASTexpression visit(IASTvariable iast, Void data) throws Exception {
        return factory.newVariable(iast.getName());
    }
}