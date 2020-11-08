/* *****************************************************************
 * ilp2 - Implantation d'un langage de programmation.
 * by Christian.Queinnec@paracamplus.com
 * See http://mooc.paracamplus.com/ilp2
 * GPL version 3
 ***************************************************************** */
package com.paracamplus.ilp2.ilp2tme4.compiler.normalizer;

import com.paracamplus.ilp1.interfaces.IASTexpression;
import com.paracamplus.ilp1.interfaces.IASTvariable;
import com.paracamplus.ilp2.ast.ASTassignment;
import com.paracamplus.ilp2.ast.ASTloop;
import com.paracamplus.ilp2.compiler.ast.ASTCfunctionDefinition;
import com.paracamplus.ilp2.compiler.ast.ASTCglobalFunctionVariable;
import com.paracamplus.ilp2.compiler.ast.ASTCprogram;
import com.paracamplus.ilp2.compiler.interfaces.IASTCfunctionDefinition;
import com.paracamplus.ilp2.compiler.interfaces.IASTCglobalFunctionVariable;
import com.paracamplus.ilp2.compiler.interfaces.IASTCprogram;
import com.paracamplus.ilp2.ilp2tme4.ast.ASTunless;

public class NormalizationFactory
extends com.paracamplus.ilp2.compiler.normalizer.NormalizationFactory
implements INormalizationFactory {


    @Override
    public IASTexpression newUnless(IASTexpression body, IASTexpression condition) {
        return new ASTunless(body,condition);
    }
}
