package com.paracamplus.ilp2.ilp2tme5bis.compiler.normalizer;

import com.paracamplus.ilp1.interfaces.IASTexpression;
import com.paracamplus.ilp2.ilp2tme5bis.ast.ASTbreak;
import com.paracamplus.ilp2.ilp2tme5bis.ast.ASTcontinue;
import com.paracamplus.ilp2.ilp2tme5bis.ast.ASTloop;

public class NormalizationFactory extends com.paracamplus.ilp2.compiler.normalizer.NormalizationFactory
implements INormalizationFactory {
    @Override
    public IASTexpression newBreak(String label) {
        return new ASTbreak(label);
    }

    @Override
    public IASTexpression newContinue(String label) {
        return new ASTcontinue(label);
    }

    @Override
    public IASTexpression newLoop(String label, IASTexpression condition, IASTexpression body) {
        return new ASTloop(label,condition,body);
    }
}
