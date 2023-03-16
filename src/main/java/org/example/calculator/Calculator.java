package org.example.calculator;

import org.example.calculator.operations.IOperation;
import org.example.calculator.operations.OperationFactory;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;

import static org.example.utils.Constants.NEWLINE;

public class Calculator implements ICalculator {
    private BufferedReader in;
    private BufferedWriter out;
    private double result;

    @Override
    public void init(BufferedReader in, BufferedWriter out) {
        this.in = in;
        this.out = out;
    }

    @Override
    public void start() throws IOException {
        String menuItem = "";
        double arg = 0;
        in.skip(21);
        while (!menuItem.equalsIgnoreCase("x")) {
            showMenu();
            menuItem = getMenuItem();
            IOperation operation = OperationFactory.getOperationByIndex(menuItem);
            if (operation == null) {
                out.write("[WARN] Operation not found");
                continue;
            }
            try {
                arg = getArg();
            } catch (Exception e) {
                out.write("[WARN] Wrong number format");
                continue;
            }
            operation.setArg1(result);
            operation.setArg2(arg);

            result = calculate(operation);
        }
    }

    private String getMenuItem() throws IOException {
        return in.readLine();
    }

    private double calculate(IOperation operation) {
        return operation.execute();
    }

    private double getArg() throws Exception {
        out.write(NEWLINE);
        out.write("Enter number: ");
        out.flush();
        return Double.valueOf(in.readLine());
    }

    private void showMenu() throws IOException {
        StringBuilder stringBuilder = new StringBuilder(NEWLINE);
        stringBuilder
                .append("MENU")
                .append(NEWLINE)
                .append("1. ADD")
                .append(NEWLINE)
                .append("2. SUB")
                .append(NEWLINE)
                .append("3. MULT")
                .append(NEWLINE)
                .append("4. DIV")
                .append(NEWLINE)
                .append("Press X to exit")
                .append(NEWLINE)
                .append("====================")
                .append(NEWLINE)
                .append("RESULT = " + result)
                .append(NEWLINE)
                .append("====================")
                .append(NEWLINE)
                .append("Enter menu item: ");

        out.write(stringBuilder.toString());
        out.flush();
    }
}
