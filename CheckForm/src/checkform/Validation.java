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
         try {
            System.out.print("Date: ");
            String dateCheck = sc.nextLine().trim();

            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            sdf.setLenient(false);

            Date date = sdf.parse(dateCheck);
            return sdf.format(date);      

        } catch (ParseException e) {
            System.err.println("Date to correct format(dd/MM/yyyy)");
        }
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


