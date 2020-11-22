package com.paracamplus.ilp2.ilp2tme5bis.compiler;

import com.paracamplus.ilp1.compiler.CompilationException;
import com.paracamplus.ilp1.compiler.interfaces.IASTClocalVariable;
import com.paracamplus.ilp2.compiler.interfaces.IASTCprogram;
import com.paracamplus.ilp2.ilp2tme5bis.compiler.interfaces.IASTCvisitor;
import com.paracamplus.ilp2.ilp2tme5bis.interfaces.IASTbreak;
import com.paracamplus.ilp2.ilp2tme5bis.interfaces.IASTcontinue;
import com.paracamplus.ilp2.ilp2tme5bis.interfaces.IASTloop;

import java.util.Set;

public class FreeVariableCollector extends com.paracamplus.ilp2.compiler.FreeVariableCollector
implements IASTCvisitor<Void, Set<IASTClocalVariable>, CompilationException> {

    public FreeVariableCollector(IASTCprogram program) {
        super(program);
    }

    @Override
    public Void visit(IASTbreak iast, Set<IASTClocalVariable> iastClocalVariables) throws CompilationException {
        return null;
    }

    @Override
    public Void visit(IASTcontinue iast, Set<IASTClocalVariable> iastClocalVariables) throws CompilationException {
        return null;
    }

    @Override
    public Void visit(IASTloop iast, Set<IASTClocalVariable> iastClocalVariables) throws CompilationException {
        iast.getCondition().accept(this, iastClocalVariables);
        iast.getBody().accept(this, iastClocalVariables);
        return null;
    }
}
