package com.paracamplus.ilp2.ilp2tme5bis.interfaces;

import com.paracamplus.ilp1.annotation.OrNull;
import com.paracamplus.ilp1.interfaces.IASTexpression;

public interface IASTcontinue extends IASTexpression {
    @OrNull
    String getLabel();
}
