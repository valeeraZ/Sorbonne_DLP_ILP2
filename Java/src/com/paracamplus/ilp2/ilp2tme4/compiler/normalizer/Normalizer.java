/* *****************************************************************
 * ilp2 - Implantation d'un langage de programmation.
 * by Christian.Queinnec@paracamplus.com
 * See http://mooc.paracamplus.com/ilp2
 * GPL version 3
 ***************************************************************** */
package com.paracamplus.ilp2.ilp2tme4.compiler.normalizer;


import com.paracamplus.ilp1.compiler.CompilationException;
import com.paracamplus.ilp1.compiler.normalizer.INormalizationEnvironment;
import com.paracamplus.ilp2.ilp2tme4.compiler.normalizer.INormalizationFactory;
import com.paracamplus.ilp1.interfaces.IASTexpression;
import com.paracamplus.ilp2.ilp2tme4.interfaces.IASTunless;
import com.paracamplus.ilp2.ilp2tme4.interfaces.IASTvisitor;

public class Normalizer 
extends com.paracamplus.ilp2.compiler.normalizer.Normalizer
implements 
 IASTvisitor<IASTexpression, INormalizationEnvironment, CompilationException> {

    INormalizationFactory factory;
    public Normalizer (INormalizationFactory factory) {
    	super(factory);
    	this.factory = factory;
    }

    @Override
    public IASTexpression visit(IASTunless iast, INormalizationEnvironment data) throws CompilationException {
        IASTexpression condition = iast.getCondition().accept(this,data);
        IASTexpression body = iast.getBody().accept(this,data);
        return this.factory.newUnless(condition, body);
    }
}
