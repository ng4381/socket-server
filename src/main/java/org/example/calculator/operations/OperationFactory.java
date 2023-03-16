package org.example.calculator.operations;

public class OperationFactory {
    public static IOperation getOperationByIndex(String menuIdx) {
        IOperation operation = null;
        switch (menuIdx) {
            case "1":
                operation = new AddOperation();
                break;
            case "2":
                operation = new SubOperation();
                break;
            case "3":
                operation = new MultOperation();
                break;
            case "4":
                operation = new DivOperation();
                break;
        }
        return operation;
    }
}
