/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package shopping;

/**
 *
 * @author Thanh Hang
 */
import java.util.Scanner;

public class Shopping {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
           Scanner sc = new Scanner(System.in);
          Validate validator = new Validate(sc);
          
          System.out.println("===== Shopping program =====");
          
          int n = validator.getInt("Input number of bills: ", 1);
          
          int total = 0;
          for(int i=1; i<=n; i++){
              int value = validator.getInt("Inpput value of bill "+i+": ",1);
              total +=value;
          }
          
          int walletAmount = validator.getInt("Input value of wallet: ", n);
          
          Person p = new Person(new Wallet(walletAmount));
          
          System.out.println("This is total of bill: "+ total);
          
          if(p.canPay(total)){
              System.out.println("You can buy it.");
          }
          else{ 
              System.out.println("You can't buy it.");
          }
        
    }
}