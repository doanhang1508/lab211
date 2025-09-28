/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package binarysearch;

import java.util.Scanner;

/**
 *
 * @author Thanh Hang
 */
public class BinarySearch {

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
        for (int i = 0; i < n; i++) {
            a[i] = validateInput("Enter a[" + (i + 1) + "]: ");
        }
        return a;
    }

    public static void displayArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static int[] sortByBubbleSort(int[] arr) {
        int n = arr.length;

        for (int i = 0; i < n - 1; i++) {
            boolean swap = false;
            for (int j = 0; j < n - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    swap = true;
                }
            }
            if (!swap) {
                break;
            }
        }
        return arr;
    }

    public static int binarySearch(int[] a, int value) {
        int n = a.length;
        int left = 0, right = n - 1;
        for (int i = 0; i < n; i++) {
            int mid = (left + right) / 2;
            if (a[mid] == value) {
                return mid;
            } else if (a[mid] > value) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return -1;
    }
//      public static int binarySearch(int[] arr, int key, int left, int right) {
//        if (left > right) {
//            return -1; // không tìm thấy
//        }
//        int mid = (left + right) / 2;
//        if (arr[mid] == key) {
//            return mid;
//        } else if (arr[mid] > key) {
//            return binarySearch(arr, key, left, mid - 1);
//        } else {
//            return binarySearch(arr, key, mid + 1, right);
//        }
//    }

    public static void main(String[] args) {
        int n = inputSizeOfArray();
        int[] a = inputValueOfArray(n);

        // Sắp xếp bằng Bubble Sort
        sortByBubbleSort(a);

        System.out.print("Sorted Array: ");
        displayArray(a);

        int key = validateInput("Enter search value: ");
        int foundIndex = binarySearch(a, key);

        if (foundIndex == -1) {
            System.out.println("Value " + key + " not found in array.");
        } else {
            System.out.println("Value " + key + " found at index " + foundIndex);
        }
    }
}
