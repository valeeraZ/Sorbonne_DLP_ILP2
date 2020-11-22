package com.paracamplus.ilp2.ilp2tme5bis.compiler;

import com.paracamplus.ilp1.compiler.CompilationException;
import com.paracamplus.ilp1.compiler.interfaces.IASTCglobalVariable;
import com.paracamplus.ilp2.ilp2tme5bis.compiler.interfaces.IASTCvisitor;
import com.paracamplus.ilp2.ilp2tme5bis.interfaces.IASTbreak;
import com.paracamplus.ilp2.ilp2tme5bis.interfaces.IASTcontinue;
import com.paracamplus.ilp2.ilp2tme5bis.interfaces.IASTloop;

import java.util.Set;

public class GlobalVariableCollector extends com.paracamplus.ilp2.compiler.GlobalVariableCollector
implements IASTCvisitor<Set<IASTCglobalVariable>,
        Set<IASTCglobalVariable>,
        CompilationException> {
    @Override
    public Set<IASTCglobalVariable> visit(IASTbreak iast, Set<IASTCglobalVariable> data) throws CompilationException {
        return data;
    }

    @Override
    public Set<IASTCglobalVariable> visit(IASTcontinue iast, Set<IASTCglobalVariable> data) throws CompilationException {
        return data;
    }

    @Override
    public Set<IASTCglobalVariable> visit(IASTloop iast, Set<IASTCglobalVariable> iastCglobalVariables) throws CompilationException {
        result = iast.getCondition().accept(this, result);
        result = iast.getBody().accept(this, result);
        return result;
    }
}
