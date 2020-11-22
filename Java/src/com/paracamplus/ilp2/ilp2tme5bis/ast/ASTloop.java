package com.paracamplus.ilp2.ilp2tme5bis.ast;

import com.paracamplus.ilp1.annotation.OrNull;
import com.paracamplus.ilp1.interfaces.IASTexpression;
import com.paracamplus.ilp2.ilp2tme5bis.interfaces.IASTloop;
import com.paracamplus.ilp2.ilp2tme5bis.interfaces.IASTvisitor;

public class ASTloop implements IASTloop {

    private final IASTexpression condition;
    private final IASTexpression body;
    private final String label;

    public ASTloop (String label, IASTexpression condition, IASTexpression body) {
        this.condition = condition;
        this.body = body;
        this.label=label;
    }

    @Override
    public IASTexpression getCondition() {
        return condition;
    }

    @Override
    public IASTexpression getBody() {
        return body;
    }

    @Override @OrNull
    public String getLabel() {
        return label;
    }

    @Override
    public <Result, Data, Anomaly extends Throwable> Result accept(
            com.paracamplus.ilp1.interfaces.IASTvisitor<Result, Data, Anomaly> visitor, Data data) throws Anomaly {
        return ((IASTvisitor<Result, Data, Anomaly>) visitor).visit(this, data);	}

}
