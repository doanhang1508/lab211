/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package bubble_sort;

import java.util.Random;
import java.util.Scanner;

/**
 *Chương trình nhập số phần tử mảng, sinh ngẫu nhiên dữ liệu,
 * hiển thị mảng trước và sau khi sắp xếp bằng Bubble Sort.
 * @author Thanh Hang
 */
public class Bubble_Sort {
    
    private static final Scanner sc = new Scanner(System.in);
    
    /**
     * Nhap so nguyen duong tu nguoi dung, co validate
     * @param msg thong bao nhap(param laf parameter: mo ta tham so cua method)
     * @return so nguyen duong
     */
    public static int validateInput(String msg){
        int num;
        while(true){
            try{
                System.out.print(msg);
                num = Integer.parseInt(sc.nextLine().trim());
                if(num>0){
                    return num;
                } 
                else{
                System.out.println("Please enter a positive number!");
            }
            } catch(NumberFormatException e){
                System.out.println("Invalid input...");
            }
        }
    }
    
      /**
     * Sinh mảng số nguyên ngẫu nhiên trong khoảng 0–99
     * @param n so phan tu
     * @return mang so nguyen
     */
    public static int[] generateRandomArray(int n){
        Random rand = new Random();
        int[] arr = new int[n];
        for(int i=0; i<n; i++){
            arr[i]=rand.nextInt(100);
        }
        return arr;
    }
    
    /**
     * In ra mảng
     * @param arr mảng số nguyên
     */
    public static void displayArray(int[] arr){
        for(int i=0; i< arr.length; i++){
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
    
    /**
     * Sắp xếp mảng bằng Bubble Sort
     * @param arr mảng số nguyên
     * @return mảng sau khi sắp xếp
     */
    public static int[] sortByBubbleSort(int[] arr){
        int n= arr.length;
  
        for( int i=0; i<n-1; i++){
             boolean swap=false;
            for(int j=0; j<n-1-i;j++){
                if(arr[j] > arr[j+1]){
                    int temp = arr[j];
                    arr[j]=arr[j+1];
                    arr[j+1]=temp;
                    swap=true;
                }
            }
            if(!swap) break;
        }
        return arr;
    }
    public static void main(String[] args) {
        int n = validateInput("Enter the number of array: ");
        int[] arr= generateRandomArray(n);
        
        System.out.print("Unsorted array: ");
        displayArray(arr);
        
        sortByBubbleSort(arr);
        
        System.out.print("Sorted array: ");
        displayArray(arr);
    }
    
}
