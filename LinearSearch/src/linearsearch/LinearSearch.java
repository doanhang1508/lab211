/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package linearsearch;

import java.util.Scanner;

/**
 *
 * @author Thanh Hang
 */
public class LinearSearch {

   
    public static Scanner sc = new Scanner(System.in);

    public static int validateInput(String msg) {
        int num;
        while (true) {
            try {
                System.out.print(msg);
                num = Integer.parseInt(sc.nextLine().trim());
                if (num > 0) {
                    return num;
                } else {
                    System.out.println("Please enter a positive number!");
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input...");
            }
        }
    }

    public static int inputSizeOfArray() {
        int n = validateInput("Enter number of array: ");
        return n;
    }
    //allow user input value of array

    public static int[] inputValueOfArray(int n) {
        int[] a = new int[n];
        for (int i = 0; i <n; i++) {
            a[i] = validateInput("Enter a[" + (i+1) + "]: ");
        }
        return a;
    }
    public static void displayArray(int[] arr){
        for(int i=0; i< arr.length; i++){
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
    public static int linearSearch(int[] arr, int key) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == key) {
                return i; // trả về chỉ số tìm thấy
            }
        }
        return -1; // không tìm thấy
    }
    public static void main(String[] args) {
         int n = inputSizeOfArray();
        int[] array = inputValueOfArray(n);

        System.out.print("Array: ");
        displayArray(array);

        int key = validateInput("Enter search value: ");
        int foundIndex = linearSearch(array, key);

        if (foundIndex == -1) {
            System.out.println("Value " + key + " not found in array.");
        } else {
            System.out.println("Value " + key + " found at index " + foundIndex);
        }
    }
    }
    

