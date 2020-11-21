package com.paracamplus.ilp2.ilp2tme5.compiler.interfaces;

import com.paracamplus.ilp2.ilp2tme5.interfaces.IASTbreak;
import com.paracamplus.ilp2.ilp2tme5.interfaces.IASTcontinue;
import com.paracamplus.ilp2.ilp2tme5.interfaces.IASTvisitor;

public interface IASTCvisitor<Result, Data, Anomaly extends Throwable> extends IASTvisitor<Result, Data, Anomaly> {
    Result visit(IASTbreak iast, Data data) throws Anomaly;
    Result visit(IASTcontinue iast, Data data) throws Anomaly;
}
