/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bmi;

/**
 *
 * @author Thanh Hang
 */
public class BMI {
     public double calculateBMI(double weightKg, double heightM) {
        return weightKg / (heightM * heightM);
    }

    public String bmiStatus(double bmi) {
        if (bmi < 19) return "Under-standard";
        if (bmi < 25) return "Standard";
        if (bmi < 30) return "Overweight";
        if (bmi < 40) return "Fat - should lose weight";
        return "Very fat - should lose weight immediately";
    }
}
