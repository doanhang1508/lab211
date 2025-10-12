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
           // Nếu là số nguyên (ví dụ 10.0, 5.00000000001)
    if (Math.abs(x - Math.round(x)) < 1e-9) {
        return String.valueOf(Math.round(x)); // In ra số nguyên
    } else {
        // Nếu là số thực, làm tròn 10 chữ số, rồi bỏ số 0 thừa
        String formatted = String.format("%.10f", x);
        while (formatted.endsWith("0")) {
            formatted = formatted.substring(0, formatted.length() - 1);
        }
        if (formatted.endsWith(".")) {
            formatted = formatted.substring(0, formatted.length() - 1);
        }
        return formatted;
    }
    }
}

