/*
 * LinearSearch.java
 * Thực hiện Linear Search (theo yêu cầu đề)
 */
package linearsearch;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author Thanh Hang
 */
public class LinearSearch {

    public static Scanner sc = new Scanner(System.in);

    // Validate input > 0
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

    // Nhập số phần tử mảng
    public static int inputSizeOfArray() {
        return validateInput("Enter number of array: ");
    }

    // Sinh mảng số ngẫu nhiên
    public static int[] generateRandomArray(int n, int bound) {
        Random rand = new Random();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = rand.nextInt(bound); // random từ 0 đến bound-1
        }
        return a;
    }

    // Hiển thị mảng
    public static void displayArray(int[] arr) {
        for (int value : arr) {
            System.out.print(value + " ");
        }
        System.out.println();
    }

    // Linear search thường (chỉ trả về index đầu tiên)
    public static int linearSearch(int[] arr, int key) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == key) {
                return i; // trả về chỉ số tìm thấy
            }
        }
        return -1; // không tìm thấy
    }
    // Linear search đệ quy: trả về index đầu tiên tìm thấy, hoặc -1 nếu không có
public static int linearSearchRecursive(int[] arr, int key, int index) {
    // Base case: hết mảng
    if (index >= arr.length) {
        return -1;
    }
    // Nếu tìm thấy tại vị trí index
    if (arr[index] == key) {
        return index;
    }
    // Gọi đệ quy cho phần tử tiếp theo
    return linearSearchRecursive(arr, key, index + 1);
}

      public static List<Integer> linearSearchAll(int[] arr, int key) {
        ArrayList<Integer> indices = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == key) {
                indices.add(i);
            }
        }
        return indices; // danh sách index tìm thấy
    }

    // Linear search đệ quy trả về tất cả index
    public static void linearSearchAllRecursive(int[] arr, int key, int index, StringBuilder result) {
        if (index >= arr.length) { // Base case: hết mảng
            return;
        }
        if (arr[index] == key) {
            if (result.length() > 0) {
                result.append(", ");
            }
            result.append(index);
        }
        linearSearchAllRecursive(arr, key, index + 1, result);
    }

    public static void main(String[] args) {
        int n = inputSizeOfArray();
        int bound = validateInput("Enter maximum random value (bound): ");

        // Sinh ngẫu nhiên mảng
        int[] array = generateRandomArray(n, bound);

        System.out.print("Array: ");
        displayArray(array);

        int key = validateInput("Enter search value: ");

        // Tìm tất cả vị trí
        StringBuilder result = new StringBuilder();
        linearSearchAllRecursive(array, key, 0, result);

        if (result.length() == 0) {
            System.out.println("Value " + key + " not found in array.");
        } else {
            System.out.println("Value " + key + " found at indices: " + result);
        }
    }
}
