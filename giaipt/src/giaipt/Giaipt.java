/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package giaipt;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.List;

/**
 *
 * @author Thanh Hang
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
         Equatation equation = new Equatation();
         Scanner sc = new Scanner(System.in);
        validation val = new validation();
        while(true){
        System.out.println("----solving equation----");
        System.out.println("1. superlative equation (ax+b= 0): ");
        System.out.println("2. quadratic equation (a^2*x+bx+c= 0): ");
        System.out.println("3. Exit");
        int choice = validation.inputInteger("Enter your choice: ", 1, 3);

        switch (choice) {
            case 1: 
                superlativeUI(equation);
                break;
            
            case 2: 
                quadraticUI(equation);
                break;
            case 3:
                    System.out.println("Bye!");
                    return;
        }
        }
    }
    public static void displayProperties(List<Float> num){
        System.out.print("Odd Number: ");
        boolean hasOdd = false;
        for (int i = 0; i < num.size(); i++) {
            float n = num.get(i);
            if (validation.isOdd(n)) {
                System.out.print(n);
                if(i<num.size()-1) System.out.print(",");
                hasOdd= true;
            }
        }
        if(!hasOdd) System.out.print("None");
        System.out.println();
        
        System.out.print("Even Number: ");
        boolean hasEven = false;
        for (int i = 0; i < num.size(); i++) {
            float n = num.get(i);
            if (validation.isEven(n)){
                System.out.print(n);
                if(i<num.size()-1) System.out.print(",");
                hasEven= true;
            }
        }
        if(!hasEven) System.out.print("None");
        System.out.println();
        
        System.out.print("Perfect Square Number: ");
        boolean hasSquare = false;
        for (int i = 0; i < num.size(); i++) {
            float n = num.get(i);
            if(validation.isPerfectSquare(n)){
                System.out.print(n);
                if(i<num.size()-1) System.out.print(",");
                hasSquare= true;
            }
        }
        if(!hasSquare) System.out.print("None");
        System.out.println();
        
    }
    public static void superlativeUI(Equatation equation){
        System.out.println("-----------Superlative Equation------");
        float a = validation.inputFloat("Enter a: ");
        float b = validation.inputFloat("Enter b: ");
        
        List<Float> res = equation.superlative(a, b);
        if(res==null){
            System.out.println("No solution.");
        }else if(res.isEmpty()){
            System.out.println("Infinite solutions");
        }else{
            System.out.println("Solution: x = "+res.get(0));
        }
        List<Float> all = new ArrayList<>();
        all.add(a);
        all.add(b);
        if(res!=null) all.addAll(res);
        displayProperties(all);
    }
    
    public static void quadraticUI(Equatation equation) {
        System.out.println("-----------Quadratic Equation------");
        float a = validation.inputFloat("Enter a: ");
        float b = validation.inputFloat("Enter b: ");
        float c = validation.inputFloat("Enter c: ");
        
        List<Float> res = equation.quadratic(a, b,c);
        if(res==null){
            System.out.println("No solution.");
        }else if(res.isEmpty()){
            System.out.println("Infinite solutions");
        }else if(res.size()==1){
            System.out.println("Solution: x1=x2= "+res.get(0));
        }
        else{
            System.out.println("Solution: x1= "+res.get(0)+" and x2= "+res.get(1));
        }
        List<Float> all = new ArrayList<>();
        all.add(a);
        all.add(b);
        all.add(c);
        if(res!=null) all.addAll(res);
        displayProperties(all);
    }
    
    

    
}
