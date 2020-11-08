package com.paracamplus.ilp2.ilp2tme4.compiler.interfaces;

import com.paracamplus.ilp2.ilp2tme4.interfaces.IASTunless;
import com.paracamplus.ilp2.ilp2tme4.interfaces.IASTvisitor;

public interface IASTCvisitor<Result, Data, Anomaly extends Throwable>
        extends IASTvisitor<Result, Data, Anomaly> {
    Result visit(IASTunless iast, Data data) throws Anomaly;
}
