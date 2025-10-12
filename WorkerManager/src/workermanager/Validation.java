/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package workermanager;

import java.util.Scanner;

/**
 *
 * @author Thanh Hang
 */
public class Validation {
     private static final Scanner sc = new Scanner(System.in);
    private static final String DATE_REGEX = "\\d{2}/\\d{2}/\\d{4}";

    public static String inputString(String msg, String regex) {
        while (true) {
            System.out.print(msg);
            String input = sc.nextLine().trim();
            if (input.isEmpty()) {
                System.out.println("⚠️ Input cannot be empty!");
                continue;
            }
            if (!input.matches(regex)) {
                System.out.println("⚠️ Invalid format!");
                continue;
            }
            return input;
        }
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

    public static double inputDouble(String msg, double min) {
        while (true) {
            try {
                System.out.print(msg);
                double n = Double.parseDouble(sc.nextLine());
                if (n <= min) {
                    System.out.printf("⚠️ Must be greater than %.2f\n", min);
                    continue;
                }
                return n;
            } catch (NumberFormatException e) {
                System.out.println("⚠️ Please enter a valid number!");
            }
        }
    }

    /**
     * Kiểm tra định dạng ngày hợp lệ (dd/MM/yyyy).
     */
  public static String checkDate() {
        while (true) {
            System.out.print("Date: ");
            String date = sc.nextLine().trim();
            if (!date.matches(DATE_REGEX)) {
                System.out.println("Date must be format (dd/MM/yyyy)");
                continue;
            }

            String[] part = date.split("/");
            int day = Integer.parseInt(part[0]);
            int month = Integer.parseInt(part[1]);
            int year = Integer.parseInt(part[2]);

            if (month < 1 || month > 12) {
                System.out.println("Month must be from 1 to 12");

                continue;

            }
            if (month >= 1 && month <= 12) {
                int[] dayOfMonth = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
                if (year % 400 == 0 || (year % 4 == 0 && year % 100 != 0)) {
                    dayOfMonth[1] = 29;
                }

                if (day < 1 || day > dayOfMonth[month - 1]) {
                    System.out.println("Invalid day!");

                    continue;
                }
            }
            return date;

        }
    }
}
