package com.paracamplus.ilp2.ilp2tme4.compiler;

import com.paracamplus.ilp1.compiler.CompilationException;
import com.paracamplus.ilp1.compiler.interfaces.IASTCglobalVariable;
import com.paracamplus.ilp2.ilp2tme4.compiler.interfaces.IASTCvisitor;
import com.paracamplus.ilp2.ilp2tme4.interfaces.IASTunless;

import java.util.Set;

public class GlobalVariableCollector extends com.paracamplus.ilp2.compiler.GlobalVariableCollector
implements IASTCvisitor<Set<IASTCglobalVariable>,
                        Set<IASTCglobalVariable>,
        CompilationException> {

    @Override
    public Set<IASTCglobalVariable> visit(IASTunless iast, Set<IASTCglobalVariable> result) throws CompilationException {
        result = iast.getCondition().accept(this,result);
        result = iast.getCondition().accept(this,result);
        return result;
    }
}
