/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package change.pkg2.pkg10.pkg16;

/**
 *
 * @author Thanh Hang
 */
public class Change21016 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        while (true) {
                System.out.println("1. Convert From Binary.");
            System.out.println("2. Convert From Decimal.");
            System.out.println("3. Convert From Hexa.");
            System.out.println("4. Exit");

            int choice = Validation.inputInteger("Enter your choice: ", 1, 4);

            switch (choice) {
                case 1:
                    String binary = Validation.checkBinary();
                    BaseConverter.convertFromBinary(binary);
                    break;
                case 2:
                    String dec = Validation.checkDecimal();
                    BaseConverter.convertFromDecimal(dec);
                    break;
                case 3:
                    String hex = Validation.checkHexa();
                    BaseConverter.convertFromHex(hex);
                    break;
                case 4:
                    System.out.println("Exit");
                    break;
            }
           
        }
    }
}

