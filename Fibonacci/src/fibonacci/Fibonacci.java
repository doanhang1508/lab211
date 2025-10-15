/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package fibonacci;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

/**
 *
 * @author Thanh Hang
 */
public class Fibonacci {
   public static long[] fibonacci(int n){
       long[] fib = new long[n+1];
       if(n>=0) fib[0]=0;
       if(n>=1) fib[1]=1;
       for(int i=2; i<=n;i++){
           fib[i]=fib[i-1]+fib[i-2];
       }
       return fib;
   }
   public static void display(long[] fib){
       for(int i=0; i<fib.length;i++){
           System.out.println(fib[i]);
       }
   }
   public static void displayNon(long[] fib){
       long max = fib[fib.length-1];
       int limit = 200;
       for(int i=0; i<limit; i++){
           boolean isFibo = false;
           for(long f: fib){
           if(f==i) isFibo=true;
           break;
       }
           if(!isFibo) System.out.println(i);
       }
   }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long[] f = fibonacci(45);
        display(f);
        //displayNon(f);
}
}
