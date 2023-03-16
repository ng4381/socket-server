package org.example;

import org.example.calculator.Calculator;

import java.math.BigDecimal;

public class Main {

    public static void main(String[] args) {
        IService calculator = new Calculator();
        SocketManager socketManager = new SocketManager(calculator);
        socketManager.runListener(4004);
    }
}