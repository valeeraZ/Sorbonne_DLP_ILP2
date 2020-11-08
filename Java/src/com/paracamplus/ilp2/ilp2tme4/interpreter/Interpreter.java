package com.paracamplus.ilp2.ilp2tme4.interpreter;

import com.paracamplus.ilp2.ilp2tme4.interfaces.IASTunless;
import com.paracamplus.ilp2.ilp2tme4.interfaces.IASTvisitor;
import com.paracamplus.ilp1.interpreter.interfaces.EvaluationException;
import com.paracamplus.ilp1.interpreter.interfaces.IGlobalVariableEnvironment;
import com.paracamplus.ilp1.interpreter.interfaces.ILexicalEnvironment;
import com.paracamplus.ilp1.interpreter.interfaces.IOperatorEnvironment;

public class Interpreter extends com.paracamplus.ilp2.interpreter.Interpreter
        implements IASTvisitor<Object, ILexicalEnvironment, EvaluationException> {

    public Interpreter(IGlobalVariableEnvironment globalVariableEnvironment,
                       IOperatorEnvironment operatorEnvironment) {
        super(globalVariableEnvironment, operatorEnvironment);
    }


    @Override
    public Object visit(IASTunless iast, ILexicalEnvironment lexenv)
            throws EvaluationException {
        Object condition = iast.getCondition().accept(this, lexenv);
        if(condition != null && condition instanceof Boolean) {
            Boolean b = (Boolean) condition;
            if(b.booleanValue()){
                return Boolean.FALSE;
            }else{
                return iast.getBody().accept(this, lexenv);
            }
        }else{
            return Boolean.FALSE;
        }

    }
}
