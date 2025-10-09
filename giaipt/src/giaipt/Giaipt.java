/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package giaipt;

import java.util.Scanner;
import java.util.List;

/**
 *
 * @author Thanh Hang
 */
public class Giaipt {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
         Scanner sc = new Scanner(System.in);
        validation val = new validation();
        System.out.println("----solving equation----");
        System.out.println("1. superlative equation (ax+b= 0): ");
        System.out.println("2. quadratic equation (a^2*x+bx+c= 0): ");
        System.out.println("Enter your choice: ");
        int choice = sc.nextInt();
        
        switch (choice) {
            case 1: {
                System.out.println("Enter a:");
                double a = sc.nextDouble();
                System.out.println("Enter b:");
                double b = sc.nextDouble();
                
                List<Double> results = (List<Double>) Equatation.superlativeEquation(a, b);
                displayAll(results);
                double check[] = {a,b};
                checkNumber(val, check);
                break;
            }
            case 2: {
                System.out.println("Enter a:");
                double a = sc.nextDouble();
                System.out.println("Enter b:");
                double b = sc.nextDouble();
                System.out.println("Enter c:");
                double c = sc.nextDouble();
    
            List<Double> results =  Equatation.quadraticEquation(a, b, c);
                
                displayAll(results);
                 double check[] = {a,b,c};
                checkNumber(val, check);
                break;
            }
        }
    }
    

    public static void displayAll(List<Double> results) {
        if (results == null) {
            System.out.println("No solution");
        } else if (results.isEmpty()) {
            System.out.println("Infinite Solution");
        } else {
            System.out.println("solutions: " + results);
        }
    }

    public static void checkNumber(validation val, double[] values) {
        System.out.println("Even Numbers: ");
        for (double v : values) {
            if (val.isEven(v)) {
                System.out.print(v+ " ");   
            }
        }
        System.out.println();
        
         System.out.println("Odd Numbers: ");
        for (double v : values) {
            if (val.isOdd(v)) {
                System.out.print(v+ " ");   
            }
        }
        System.out.println();
        
         System.out.println("Percert Square Numbers: ");
        for (double v : values) {
            if (val.isPercertSquare(v)) {
                System.out.print(v+ " ");   
            }
        }
        System.out.println();
    }
    
}
