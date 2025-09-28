/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package change.pkg2.pkg10.pkg16;

import java.util.Scanner;

/**
 *
 * @author Thanh Hang
 */
public class Validation {
    private static Scanner sc = new Scanner(System.in);
    
    private static String BINARY_REGEX = "[0-1]+";
    private static String DECIMAL_REGEX = "[0-9]+";
    private static String HEXA_REGEX = "[0-9A-F]+";
    
    public static int inputInteger(String msg, int min, int max){
        while(true){
            try{
                System.out.println(msg);
            int value = Integer.parseInt(sc.nextLine().trim());
            if(value<min||value>max){
                System.out.println("Value must be between " + min + " and " + max);
            }else{
                return value;
            }
            }catch(NumberFormatException e){
                System.err.println("Invalid input! Please enter a number");
            }
        }
    }
    
    public static String checkBinary(){
        System.out.println("Enter binary number: ");
        while(true){
            try{
                String value = sc.nextLine().trim();
            if(!value.matches(BINARY_REGEX)){
                System.err.println("Must enter 0 or 1 (non-empty");
            }else{
                return value;
            }
            }catch(NumberFormatException e){
                System.err.println("Invalid input! Please enter 0 or 1");
            }
        }
    }
     public static String checkDecimal(){
        System.out.println("Enter decimal number: ");
        while(true){
            try{
                String value = sc.nextLine().trim();
            if(!value.matches(DECIMAL_REGEX)){
                System.err.println("Must enter 0-9 (non-empty");
            }else{
                return value;
            }
            }catch(NumberFormatException e){
                System.err.println("Invalid input! Please enter 0-9");
            }
        }
    }
      public static String checkHexa(){
    System.out.println("Enter hexadecimal number: ");
        while(true){
            try{
                String value = sc.nextLine().trim();
            if(!value.matches(HEXA_REGEX)){
                System.err.println("Must enter 0-9 or A-F (non-empty");
            }else{
                return value;
            }
            }catch(NumberFormatException e){
                System.err.println("Invalid input! Please enter 0-9 or A-F");
            }
        }
    }
            
}
