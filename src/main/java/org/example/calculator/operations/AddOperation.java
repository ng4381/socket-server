package org.example.calculator.operations;

import java.math.BigDecimal;

public class AddOperation extends AbstractOperation {

    @Override
    public double execute() {
        BigDecimal res = BigDecimal.valueOf(getArg1());
        res = res.add(BigDecimal.valueOf(getArg2()));
        return res.doubleValue();
    }
}
