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
        String phone = Validation.inputWithValidation("phone", "Enter phone number: ");
        String email = Validation.inputWithValidation("email", "Enter email: ");
        String date = Validation.inputWithValidation("date", "Enter date (dd/MM/yyyy): ");
        System.out.println("✅ All inputs are valid!");
    }
}
