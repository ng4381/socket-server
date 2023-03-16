package org.example.calculator.operations;

import java.math.BigDecimal;

public class MultOperation extends AbstractOperation {

    @Override
    public double execute() {
        BigDecimal res = BigDecimal.valueOf(getArg1());
        res = res.multiply(BigDecimal.valueOf(getArg2()));
        return res.doubleValue();
    }
}
