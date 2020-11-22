package com.paracamplus.ilp2.ilp2tme5bis.compiler.normalizer;

import com.paracamplus.ilp1.compiler.CompilationException;
import com.paracamplus.ilp1.compiler.normalizer.INormalizationEnvironment;
import com.paracamplus.ilp1.interfaces.IASTexpression;
import com.paracamplus.ilp2.ilp2tme5bis.interfaces.IASTbreak;
import com.paracamplus.ilp2.ilp2tme5bis.interfaces.IASTcontinue;
import com.paracamplus.ilp2.ilp2tme5bis.interfaces.IASTloop;
import com.paracamplus.ilp2.ilp2tme5bis.interfaces.IASTvisitor;

public class Normalizer extends com.paracamplus.ilp2.compiler.normalizer.Normalizer
implements IASTvisitor<IASTexpression, INormalizationEnvironment, CompilationException> {

    public Normalizer(INormalizationFactory factory) {
        super(factory);
    }

    @Override
    public IASTexpression visit(IASTbreak iast, INormalizationEnvironment env) throws CompilationException {
        return ((INormalizationFactory)factory).newBreak(iast.getLabel());
    }

    @Override
    public IASTexpression visit(IASTcontinue iast, INormalizationEnvironment env) throws CompilationException {
        return ((INormalizationFactory)factory).newContinue(iast.getLabel());
    }

    @Override
    public IASTexpression visit(IASTloop iast, INormalizationEnvironment env) throws CompilationException {
        String label = iast.getLabel();
        IASTexpression condition = iast.getCondition().accept(this, env);
        IASTexpression body = iast.getBody().accept(this, env);
        return ((INormalizationFactory)factory).newLoop(label,condition,body);
    }
}
