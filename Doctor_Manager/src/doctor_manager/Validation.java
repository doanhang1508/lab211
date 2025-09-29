/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package doctor_manager;

/**
 *
 * @author Thanh Hang
 */
import java.util.Scanner;

public class Validation {
         private static Scanner sc = new Scanner(System.in);
         private static String[] days = {
    "Sunday", "Monday", "Tuesday", "Wednesday", 
    "Thursday", "Friday", "Saturday"
};

    /**
     * Nhập số nguyên trong khoảng [min, max]
     */
    public static int inputInteger(String msg, int min, int max) {
        while (true) {
            try {
                System.out.print(msg);
                String line = sc.nextLine().trim();
                int value = Integer.parseInt(line);
                if (value < min || value > max) {
                    System.out.println("Value must be between " + min + " and " + max);
                } else {
                    return value;
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid number. Please try again.");
            }
        }
    }

    public static String inputString(String msg, String regex) {
        while (true) {
            System.out.print(msg);
            String value = sc.nextLine().trim();
             if (value.isEmpty()) { // cho phép bỏ trống
                 System.out.println("Input must not empty");
        }
            if (value.isEmpty()) {
                System.out.println("Input cannot be empty.");
            } else if (!value.matches(regex)) {
                System.out.println("Invalid input format.");
            } else {
                return value;
            }
        }
    }
    /**
     * Nhập chuỗi theo regex (ví dụ: cho phép cả khoảng trắng)
     */
    public static String inputStringEmpty(String msg, String regex) {
        while (true) {
            System.out.print(msg);
            String value = sc.nextLine().trim();
             if (value.isEmpty()) { // cho phép bỏ trống
            return "";
        }
            if (value.isEmpty()) {
                System.out.println("Input cannot be empty.");
            } else if (!value.matches(regex)) {
                System.out.println("Invalid input format.");
            } else {
                return value;
            }
        }
    }
    public static String checkDuplicated(String value){
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<value.length();i++){
            char c = value.charAt(i);
            if(sb.indexOf(String.valueOf(c))==-1){
                sb.append(c);
            }
        }
        return sb.toString();
    }
    /**
     * Nhập availability (>= 0)
     */
    public static String inputAvailability(String msg, String regex) {
         while (true) {
        System.out.print(msg);
        String line = sc.nextLine().trim();

        // nếu nhập rỗng
        if (line.isEmpty()) {
            System.out.println("Input must not empty");
        }

        try {
            int value = Integer.parseInt(line); // thử parse
            if (!line.matches(regex)) {
                System.out.println("Availability must be 1-7");
                continue;
            }
              line = checkDuplicated(line);

            StringBuilder daysStr = new StringBuilder();
            for (int i=0; i<line.length();i++) {
                char c = line.charAt(i);
                daysStr.append(days[(c-'0') - 1]).append(" ");
            }

            String result = daysStr.toString().trim();
            return result;
        } catch (NumberFormatException e) {
            // bắt được khi người dùng nhập chữ hoặc ký tự ko phải số
            System.out.println("Invalid format. Please try again.");
        }
    }
    }
         public static String inputAvailabilityEmpty(String msg, String regex) {
         while (true) {
        System.out.print(msg);
        String line = sc.nextLine().trim();

        // nếu nhập rỗng
        if (line.isEmpty()) {
            return ""; // cho phép bỏ trống (tùy bạn muốn)
        }

        try {
            int value = Integer.parseInt(line); // thử parse
            if (!line.matches(regex)) {
                System.out.println("Availability must be 1-7");
                continue;
            }
             StringBuilder daysStr = new StringBuilder();
            for (int i=0; i<line.length();i++) {
                char c = line.charAt(i);
                daysStr.append(days[(c-'0') - 1]).append(" ");
            }

            String result = daysStr.toString().trim();
            return result;
        } catch (NumberFormatException e) {
            // bắt được khi người dùng nhập chữ hoặc ký tự ko phải số
            System.out.println("Invalid format. Please try again.");
        }
    }
}
}
