/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package giaipt;

import java.util.Scanner;

/**
 *
 * @author Thanh Hang
 */
public class validation {
    
    private static Scanner sc = new Scanner(System.in);

    public static boolean isOdd(float n) {
        return n % 2 != 0;
    }

    public static boolean isEven(float n) {
        return n % 2 == 0;
    }

    public static boolean isPerfectSquare(float n) {
        if (n < 0) {
            return false;
        }
        double sqrt = Math.sqrt(n);
        return sqrt == (int) sqrt;
    }

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
      public static float inputFloat(String msg) {
        while (true) {
            try {
                System.out.print(msg);
                return Float.parseFloat(sc.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("Please input number");
            }
        }
    }
}
