/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package bmi;

/**
 *
 * @author Thanh Hang
 */
public class Main {

    public static void main(String[] args) {
        Calculate calculator = new Calculate();
        BMI bmiService = new BMI();

        while (true) {
            System.out.println("===== LAB211 — Calculator Suite =====");
            System.out.println("1. Normal Calculator");
            System.out.println("2. BMI Calculator");
            System.out.println("3. Exit");

            int choice = Validation.inputInteger("Enter your choice [1-3]: ", 1, 3);

            switch (choice) {
                case 1:
                    calculator.calculate();
                    break;

                case 2:
                    double weight = Validation.inputPositiveDouble("Enter weight (kg): ");
                    double height = Validation.inputPositiveDouble("Enter height (m): ");
                    double bmi = bmiService.calculateBMI(weight, height);
                    System.out.printf("BMI = %.2f%n", bmi);
                    System.out.println("Status: " + bmiService.bmiStatus(bmi));
                    break;

                case 3:
                    System.out.println("Bye!");
                    return;
            }

            System.out.println();
        }
    }
}
