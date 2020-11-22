package com.paracamplus.ilp2.ilp2tme5bis.interpreter;

import com.paracamplus.ilp1.interpreter.interfaces.EvaluationException;

public class BreakException extends EvaluationException {

    public BreakException(String msg) {
        super(msg);
    }
}
