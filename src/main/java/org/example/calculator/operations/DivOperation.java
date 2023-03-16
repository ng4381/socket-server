package org.example.calculator.operations;

import java.math.BigDecimal;

public class DivOperation extends AbstractOperation {

    @Override
    public double execute() {
        BigDecimal res = BigDecimal.valueOf(getArg1());
        res = res.divide(BigDecimal.valueOf(getArg2()));
        return res.doubleValue();
    }
}
