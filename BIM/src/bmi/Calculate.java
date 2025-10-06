/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bmi;


/**
 *
 * @author Thanh Hang
 */
public class Calculate {
    
     public double calculate() {
        double result = Validation.inputDouble("Enter number: ");
        while (true) {
            char op = Validation.inputOperator("Enter operator (+ - * / ^ or = to finish): ", true);
            if (op == '=') {
                System.out.printf("Result: %s%n", fmt(result));
                return result;
            }
            double rhs = readRightOperand(op);
            result = apply(result, op, rhs);
            System.out.println("Memory = " + fmt(result));
        }
    } 

    private double readRightOperand(char op) {
        if (op == '/') {
            // tránh chia cho 0
            while (true) {
                double v = Validation.inputDouble("Enter number: ");
                if (v != 0) return v;
                System.err.println("Cannot divide by zero. Enter a non-zero number.");
            }
        }
        return Validation.inputDouble("Enter number: ");
    }

    private double apply(double a, char op, double b) {
        switch (op) {
            case '+': return a + b;
            case '-': return a - b;
            case '*': return a * b;
            case '/': return a / b;          // b đã được kiểm tra != 0
            case '^': return Math.pow(a, b); // số mũ
            default:  throw new IllegalArgumentException("Unsupported operator: " + op);
        }
    }

    private String fmt(double x) {
        // Hiển thị đẹp: bỏ .0 nếu là số nguyên
        if (Math.abs(x - Math.rint(x)) < 1e-12) return String.valueOf((long) Math.rint(x));
        return String.format("%.10f", x).replaceAll("0+$", "").replaceAll("\\.$", "");
    }
     
}
