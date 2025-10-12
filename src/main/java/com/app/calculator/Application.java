package com.app.calculator;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application {

    public static int add(int a, int b) {
        int c = 0;
        c = a + b;
        return c;
    }

    public static int sub(int a, int b) {
        int c = 0;
        c = a - b;
        return c;
    }

    public static int mul(int a, int b) {
        int c = 0;
        c = a * b;
        return c;
    }

    public static void div(int a, int b) {
        int c = 0;
        try {
            c = a / b;
            System.out.println(c);
        } catch (ArithmeticException e) {
            System.out.println((e));
        }
    }

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}