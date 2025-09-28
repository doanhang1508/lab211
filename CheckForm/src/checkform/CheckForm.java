/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package checkform;

import java.util.Scanner;

/**
 *
 * @author Thanh Hang
 */
public class CheckForm {

 
    public static void main(String[] args) {
      Scanner sc = new Scanner(System.in);
      while(true){
          System.out.print("Enter phone number: ");
          String phone=sc.nextLine().trim();
          String msg = Validation.checkPhone(phone);
          if(msg.isEmpty()) break;
          System.out.println(msg);
      }
      while(true){
          System.out.print("Enter email: ");
          String email = sc.nextLine().trim();
          String msg = Validation.checkEmail(email);
          if(msg.isEmpty()) break;
          System.out.println(msg);
      }
      while(true){
          System.out.print("Enter date: ");
          String date = sc.nextLine().trim();
          String msg = Validation.checkDate(date);
          if(msg.isEmpty()) break;
          System.out.println(msg);
      }
        System.out.println("Successfull");
}
}
