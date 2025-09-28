/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package selection_sort;

import java.util.Scanner;

/**
 *
 * @author Thanh Hang
 */
public class Selection_Sort {

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
    public static void sortBySelectionSort(int[] a){
        int n = a.length;
        for(int i=0; i<n-1;i++){
            int minIndex=i;
            for(int j=i+1; j<n;j++){
                if(a[j]<a[minIndex]){
                    minIndex=j;
                }
            }
            int temp = a[i];
                a[i]=a[minIndex];
                a[minIndex]=temp;
        }
    }
     public static void displayArray(int[] arr){
        for(int i=0; i< arr.length; i++){
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
     public static int[] removeDuplicatesSorted(int[] a) {
    if (a.length == 0) return a;

    int[] temp = new int[a.length];
    int j = 0;
    temp[j++] = a[0]; // luôn thêm phần tử đầu tiên

    for (int i = 1; i < a.length; i++) {
        if (a[i] != a[i - 1]) {
            temp[j++] = a[i]; // chỉ thêm khi khác phần tử trước
        }
    }

    // Tạo mảng result đúng kích thước j bằng vòng for
    int[] result = new int[j];
    for (int i = 0; i < j; i++) {
        result[i] = temp[i];
    }

    return result;
}

    public static void main(String[] args) {
        int n = inputSizeOfArray();
        int[] a =inputValueOfArray(n);
        
        System.out.print("Unsorted array: ");
        displayArray(a);
        
        sortBySelectionSort(a);
        
        System.out.print("Sorted array: ");
        displayArray(a);
        a = removeDuplicatesSorted(a);
        displayArray(a);
        
    }

}
