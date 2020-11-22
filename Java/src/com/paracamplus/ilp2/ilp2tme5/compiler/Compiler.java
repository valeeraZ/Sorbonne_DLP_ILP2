package com.paracamplus.ilp2.ilp2tme5.compiler;

import com.paracamplus.ilp1.compiler.AssignDestination;
import com.paracamplus.ilp1.compiler.CompilationException;
import com.paracamplus.ilp1.compiler.NoDestination;
import com.paracamplus.ilp1.compiler.VoidDestination;
import com.paracamplus.ilp1.compiler.interfaces.IASTCglobalVariable;
import com.paracamplus.ilp1.compiler.interfaces.IGlobalVariableEnvironment;
import com.paracamplus.ilp1.compiler.interfaces.IOperatorEnvironment;

import com.paracamplus.ilp1.interfaces.IASTvariable;
import com.paracamplus.ilp2.compiler.interfaces.IASTCprogram;

import com.paracamplus.ilp2.ilp2tme5.compiler.interfaces.IASTCvisitor;
import com.paracamplus.ilp2.ilp2tme5.compiler.normalizer.INormalizationFactory;
import com.paracamplus.ilp2.ilp2tme5.compiler.normalizer.NormalizationFactory;
import com.paracamplus.ilp2.ilp2tme5.compiler.normalizer.Normalizer;
import com.paracamplus.ilp2.ilp2tme5.interfaces.IASTbreak;
import com.paracamplus.ilp2.ilp2tme5.interfaces.IASTcontinue;
import com.paracamplus.ilp2.interfaces.IASTloop;
import com.paracamplus.ilp2.interfaces.IASTprogram;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.StringWriter;
import java.util.Set;

public class Compiler extends com.paracamplus.ilp2.compiler.Compiler
implements IASTCvisitor<Void, Compiler.Context, CompilationException> {

    protected int nbWhile = 0;

    public Compiler(IOperatorEnvironment ioe, IGlobalVariableEnvironment igve) {
        super(ioe, igve);
    }

    public IASTCprogram normalize(IASTprogram program)
            throws CompilationException {
        INormalizationFactory nf = new NormalizationFactory();
        Normalizer normalizer = new Normalizer(nf);
        IASTCprogram newprogram = normalizer.transform(program);
        return newprogram;
    }

    @Override
    public String compile(com.paracamplus.ilp1.interfaces.IASTprogram program) throws CompilationException {
        return compile((IASTprogram)program);
    }

    public String compile(IASTprogram program)
            throws CompilationException {

        IASTCprogram newprogram = normalize(program);
        newprogram = ((IASTCprogram) optimizer.transform(newprogram));

        GlobalVariableCollector gvc = new GlobalVariableCollector();
        Set<IASTCglobalVariable> gvs = gvc.analyze(newprogram);
        newprogram.setGlobalVariables(gvs);

        FreeVariableCollector fvc = new FreeVariableCollector(newprogram);
        newprogram = (fvc.analyze());

        Context context = new Context(NoDestination.NO_DESTINATION);
        StringWriter sw = new StringWriter();
        try {
            out = new BufferedWriter(sw);
            visit(newprogram, context);
            out.flush();
        } catch (IOException exc) {
            throw new CompilationException(exc);
        }
        return sw.toString();
    }

    @Override
    public Void visit(IASTloop iast, Context context)
            throws CompilationException {
        emit("while ( 1 ) { \n");
        IASTvariable tmp = context.newTemporaryVariable();
        emit("  ILP_Object " + tmp.getMangledName() + "; \n");
        Context c = context.redirect(new AssignDestination(tmp));
        iast.getCondition().accept(this, c);
        emit("  if ( ILP_isEquivalentToTrue(");
        emit(tmp.getMangledName());
        emit(") ) {\n");
        Context cb = context.redirect(VoidDestination.VOID_DESTINATION);
        nbWhile++;
        iast.getBody().accept(this, cb);
        emit("\n} else { \n");
        emit("    break; \n");
        emit("\n}\n}\n");
        whatever.accept(this, context);
        nbWhile--;
        return null;
    }

    @Override
    public Void visit(IASTbreak iast, Context context) throws CompilationException {
        emit("break; \n");
        if (nbWhile < 1)
            throw new CompilationException("The keyword continue is not in a loop");
        return null;
    }

    @Override
    public Void visit(IASTcontinue iast, Context context) throws CompilationException {
        emit("continue; \n");
        if (nbWhile < 1)
            throw new CompilationException("The keyword break is not in a loop");
        return null;
    }
}
