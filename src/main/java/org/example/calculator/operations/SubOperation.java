package org.example.calculator.operations;

import java.math.BigDecimal;

public class SubOperation extends AbstractOperation {

    @Override
    public double execute() {
        BigDecimal res = BigDecimal.valueOf(getArg1());
        res = res.subtract(BigDecimal.valueOf(getArg2()));
        return res.doubleValue();
    }
}
