/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package checkform;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;
import java.util.regex.Pattern;

/**
 *
 * @author Thanh Hang
 */
public class Validation {

    private static Scanner sc = new Scanner(System.in);
    static String DATE_REGEX = "\\d{2}/\\d{2}/\\d{4}";
    static String EMAIL_REGEX = "^[A-Za-z0-9]+@[A-Za-z]+\\.[A-Za-z]+$";
    static String PHONE_REGEX = "\\d+";

    public static String checkPhone() {
        while (true) {
            System.out.print("Phone: ");
            String phone = sc.nextLine().trim();
            if (!phone.matches("\\d+")) {
                System.out.println("Phone number must be number.");
            } else if (phone.length() != 10) {
                System.out.println("Phone number have 10 digit.");
            } else {
                return phone;
            }
        }
    }

    public static String checkEmail() {
        while (true) {
            System.out.print("Email: ");
            String email = sc.nextLine().trim();
            if (!email.matches(EMAIL_REGEX)) {
                System.out.println("Invalid email");
            } else {
                return email;
            }
        }
    }

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

    public static String inputWithValidation(String type) {
        while (true) {
            String msg = "";

            switch (type.toLowerCase()) {
                case "phone":
                    msg = checkPhone();
                    break;
                case "email":
                    msg = checkEmail();
                    break;
                case "date":
                    msg = checkDate();
                    break;
            }

            return msg;
        }
    }
}
