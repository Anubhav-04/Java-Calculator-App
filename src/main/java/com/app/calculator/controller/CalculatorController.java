package com.app.calculator.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.app.calculator.Application;
@RestController
public class CalculatorController {

    @GetMapping("/add")
    public String add(@RequestParam int a, @RequestParam int b) {
        int result = Application.add(a, b);
        return "Sum: " + result;
    }

    @GetMapping("/sub")
    public String sub(@RequestParam int a, @RequestParam int b) {
        int result = Application.sub(a, b);
        return "Difference: " + result;
    }

    @GetMapping("/mul")
    public String mul(@RequestParam int a, @RequestParam int b) {
        int result = Application.mul(a, b);
        return "Product: " + result;
    }

    @GetMapping("/div")
    public String div(@RequestParam int a, @RequestParam int b) {
        if (b == 0) {
            return "Error: Division by zero not allowed.";
        }
        int result = a / b;
        return "Quotient: " + result;
    }
}
