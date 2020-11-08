package com.paracamplus.ilp2.ilp2tme4.ast;

import com.paracamplus.ilp1.ast.ASTexpression;
import com.paracamplus.ilp1.interfaces.IASTexpression;
import com.paracamplus.ilp2.ilp2tme4.interfaces.IASTunless;
import com.paracamplus.ilp2.ilp2tme4.interfaces.IASTvisitor;

//import com.paracamplus.ilp1.interfaces.IASTvisitor;

public class ASTunless extends ASTexpression implements IASTunless {

    private final IASTexpression body;
    private final IASTexpression condition;


    public ASTunless(IASTexpression body, IASTexpression condition) {
        this.body = body;
        this.condition = condition;
    }

    @Override
    public IASTexpression getBody() {
        return body;
    }

    @Override
    public IASTexpression getCondition() {
        return condition;
    }


    @Override
    public <Result, Data, Anomaly extends Throwable> Result accept(com.paracamplus.ilp1.interfaces.IASTvisitor<Result, Data, Anomaly> visitor, Data data) throws Anomaly {
        return ((IASTvisitor<Result, Data, Anomaly>)visitor).visit(this,data);
    }
}
