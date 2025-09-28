/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package checkform;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.regex.Pattern;

/**
 *
 * @author Thanh Hang
 */
public class Validation {
    public static String checkPhone(String phone){
        if(!phone.matches("\\d+")){
            return "Phone number must be number.";
        }
        if(phone.length()>10){
            return "Phone number have 10 digit.";
        }
        return "";
    }
    public static String checkEmail(String email){
        if(!email.matches("^[A-Z0-9a-z._%+-]+@[A-Za-z0-9.-]+\\\\.[A-Za-z]{2,4}$")){
            return "Invalid format.";
        }
        return "";
    }
    public static String checkDate(String date){
        if(!date.matches("\\d{2}/\\d{2}/\\d{4}")){
            return "Date must be format (dd/MM/yyyy)";
        }
        String[] part = date.split("/");
        int day = Integer.parseInt(part[0]);
        int month = Integer.parseInt(part[1]);
        int year = Integer.parseInt(part[2]);
        if(month<1 || month >12){
            return "Month must be from 1 to 12";
        }
        int[] dayOfMonth={31,28,31,30,31,30,31,31,30,31,30,31};
        if(year % 400 ==0 ||(year%4==0 && year%100!=0)){
            dayOfMonth[1]=29;
        }
        if(day<1||day>dayOfMonth[month-1]){
            return "Invalid day!";
        }
        return "";
    }
}
