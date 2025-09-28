/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package shopping;

/**
 *
 * @author Thanh Hang
 */
public class Person {
    private Wallet wallet;
    
    public Person(Wallet wallet){
        this.wallet=wallet;
    }
    public boolean canPay(int totalBill){
        return wallet.getAmount() >= totalBill;
    }
}
