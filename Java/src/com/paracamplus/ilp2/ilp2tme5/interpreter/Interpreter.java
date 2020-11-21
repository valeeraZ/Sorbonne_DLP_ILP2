package com.paracamplus.ilp2.ilp2tme5.interpreter;

import com.paracamplus.ilp1.interpreter.interfaces.EvaluationException;
import com.paracamplus.ilp1.interpreter.interfaces.IGlobalVariableEnvironment;
import com.paracamplus.ilp1.interpreter.interfaces.ILexicalEnvironment;
import com.paracamplus.ilp1.interpreter.interfaces.IOperatorEnvironment;
import com.paracamplus.ilp2.ilp2tme5.interfaces.IASTbreak;
import com.paracamplus.ilp2.ilp2tme5.interfaces.IASTcontinue;
import com.paracamplus.ilp2.ilp2tme5.interfaces.IASTvisitor;
import com.paracamplus.ilp2.interfaces.IASTfunctionDefinition;
import com.paracamplus.ilp2.interfaces.IASTloop;
import com.paracamplus.ilp2.interfaces.IASTprogram;

public class Interpreter extends com.paracamplus.ilp2.interpreter.Interpreter
        implements IASTvisitor<Object, ILexicalEnvironment, EvaluationException> {

    public Interpreter(IGlobalVariableEnvironment globalVariableEnvironment, IOperatorEnvironment operatorEnvironment) {
        super(globalVariableEnvironment, operatorEnvironment);
    }

    @Override
    public Object visit(com.paracamplus.ilp1.interfaces.IASTprogram iast, ILexicalEnvironment lexenv) throws EvaluationException  {
        return visit((IASTprogram)iast, lexenv);
    }

    public Object visit(IASTprogram iast, ILexicalEnvironment lexenv)
            throws EvaluationException {
        for ( IASTfunctionDefinition fd : iast.getFunctionDefinitions() ) {
            Object f = this.visit(fd, lexenv);
            String v = fd.getName();
            getGlobalVariableEnvironment().addGlobalVariableValue(v, f);
        }
        try {
            return iast.getBody().accept(this, lexenv);
        } catch (Exception exc) {
            return exc;
        }
    }

    @Override
    public Object visit(IASTloop iast, ILexicalEnvironment lexenv) throws EvaluationException {
        while ( true ) {
            Object condition = iast.getCondition().accept(this, lexenv);
            if ( condition instanceof Boolean ) {
                Boolean c = (Boolean) condition;
                if ( ! c ) {
                    break;
                }
            }
            try {
                iast.getBody().accept(this, lexenv);
            } catch (BreakException e){
                break;
            } catch (ContinueException e){
                continue;
            }
        }
        return Boolean.FALSE;
    }

    @Override
    public Object visit(IASTbreak iast, ILexicalEnvironment iLexicalEnvironment) throws EvaluationException {
        throw new BreakException("break");
    }

    @Override
    public Object visit(IASTcontinue iast, ILexicalEnvironment iLexicalEnvironment) throws EvaluationException {
        throw new ContinueException("continue");
    }
}
