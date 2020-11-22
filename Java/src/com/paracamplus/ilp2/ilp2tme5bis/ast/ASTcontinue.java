package com.paracamplus.ilp2.ilp2tme5bis.ast;

import com.paracamplus.ilp1.annotation.OrNull;
import com.paracamplus.ilp1.interfaces.IASTvisitor;
import com.paracamplus.ilp2.ilp2tme5bis.interfaces.IASTcontinue;

public class ASTcontinue implements IASTcontinue {

    private String label;

    public ASTcontinue (String label) {
        this.label = label;
    }

    @Override @OrNull
    public String getLabel() {
        return label;
    }

    @Override
    public <Result, Data, Anomaly extends Throwable> Result accept(IASTvisitor<Result, Data, Anomaly> visitor, Data data) throws Anomaly {
        return ((com.paracamplus.ilp2.ilp2tme5bis.interfaces.IASTvisitor<Result, Data, Anomaly>)visitor).visit(this,data);
    }


}
