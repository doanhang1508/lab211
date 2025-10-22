/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package graph;

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
                System.out.print(msg);
                int n = Integer.parseInt(sc.nextLine());
                if (n < min || n > max) {
                    System.out.printf("⚠️ Enter number in range [%d - %d]\n", min, max);
                    continue;
                }
                return n;
            } catch (NumberFormatException e) {
                System.out.println("⚠️ Please enter a valid integer!");
            }
        }
    }
}
