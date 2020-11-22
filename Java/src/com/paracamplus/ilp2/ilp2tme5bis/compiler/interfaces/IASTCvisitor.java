package com.paracamplus.ilp2.ilp2tme5bis.compiler.interfaces;

import com.paracamplus.ilp2.ilp2tme5bis.interfaces.IASTbreak;
import com.paracamplus.ilp2.ilp2tme5bis.interfaces.IASTcontinue;
import com.paracamplus.ilp2.ilp2tme5bis.interfaces.IASTloop;
import com.paracamplus.ilp2.ilp2tme5bis.interfaces.IASTvisitor;

public interface IASTCvisitor<Result, Data, Anomaly extends Throwable> extends IASTvisitor<Result, Data, Anomaly> {
    Result visit(IASTbreak iast, Data data) throws Anomaly;
    Result visit(IASTcontinue iast, Data data) throws Anomaly;
    Result visit(IASTloop iast, Data data) throws Anomaly;
}
