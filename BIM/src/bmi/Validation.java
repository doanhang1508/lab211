/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bmi;

import java.util.Scanner;

/**
 *
 * @author Thanh Hang
 */
public class Validation {

    private static final Scanner sc = new Scanner(System.in);

    public static int inputInteger(String msg, int min, int max) {
        while (true) {
            try {
                System.out.println(msg);
                int value = Integer.parseInt(sc.nextLine().trim());
                if (value < min || value > max) {
                    System.out.println("Value must be between " + min + " and " + max);
                } else {
                    return value;
                }
            } catch (NumberFormatException e) {
                System.err.println("Invalid input! Please enter a number");
            }
        }
    }

    public static double inputDouble(String msg) {
        while (true) {
            System.out.print(msg);
            String s = sc.nextLine().trim();
            try {
                return Double.parseDouble(s);
            } catch (NumberFormatException e) {
                System.err.println("Invalid number. Try again.");
            }
        }
    }

    public static double inputDoubleInRange(String prompt, double min, double max) {
        while (true) {
            double v = inputDouble(prompt);
            if (v >= min && v <= max) {
                return v;
            }
            System.err.printf("Value must be meters", min, max);
        }
    }

    // Chấp nhận: + - * / ^ =  ( '=' để kết thúc tính )
    public static char inputOperator(String msg) {
        while (true) {
            System.out.print(msg);
            String s = sc.nextLine().trim();
            if (s.length() == 1) {
                char c = s.charAt(0);
                if (c == '+' || c == '-' || c == '*' || c == '/' || c == '^' ||  c == '=') {
                    return c;
                }
            }
            System.err.println("Operator must be one of: + - * / ^ =" );
        }
    }
}
