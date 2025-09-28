/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package shopping;

/**
 * kiem tra tinh hop le cua input
 * @author Thanh Hang
 */
import java.util.Scanner;

public class Validate {
    private Scanner sc;
    
    public Validate(Scanner sc){
        this.sc = sc;
    }
    
    public int getInt(String message, int min){
        
        int value;
        
        while(true){
            
            System.out.print(message);
            
            try{
                value = Integer.parseInt(sc.nextLine());
                if(value>=min){
                    return value;
                }
                else{
                    System.out.println("Value must be >= "+min);
                }
            } catch(NumberFormatException e){
                System.out.println("Invalid input! Please enter a number.");
            }
        }
        
    }
    
        public double getDouble(String message, double min) {
        double value;
        while (true) {
            System.out.print(message);
            try {
                value = Double.parseDouble(sc.nextLine());
                if (value >= min) return value;
                else System.out.println("Value must be >= " + min);
            } catch (NumberFormatException e) {
                System.out.println("Invalid input! Please enter a decimal number.");
            }
        }
    }

    // nhập chuỗi hợp lệ theo regex
    public String getString(String message, String regex) {
        String value;
        while (true) {
            System.out.print(message);
            value = sc.nextLine();
            if (value.matches(regex)) {
                return value;
            } else {
                System.out.println("Invalid input! Please follow format: " + regex);
            }
        }
    }
}
