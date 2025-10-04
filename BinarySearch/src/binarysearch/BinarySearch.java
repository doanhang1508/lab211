/*
 * BinarySearch.java
 * Thực hiện Binary Search theo yêu cầu đề
 */
package binarysearch;

import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author Thanh Hang
 */
public class BinarySearch {

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

    // Sinh mảng số nguyên ngẫu nhiên
    public static int[] generateRandomArray(int n, int bound) {
        Random rand = new Random();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = rand.nextInt(bound);
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

    // Sắp xếp bằng Bubble Sort
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
            if (!swap) break;
        }
        return arr;
    }

    // Binary Search dạng iterative
    public static int binarySearch(int[] a, int key) {
        int left = 0, right = a.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (a[mid] == key) {
                return mid;
            } else if (a[mid] < key) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }

    // Binary Search dạng recursive
    public static int binarySearchRecursive(int[] a, int key, int left, int right) {
        if (left > right) return -1;
        int mid = (left + right) / 2;
        if (a[mid] == key) return mid;
        else if (a[mid] > key) return binarySearchRecursive(a, key, left, mid - 1);
        else return binarySearchRecursive(a, key, mid + 1, right);
    }
    public static int binarySearchFirst(int[] a, int key) {
    int left = 0, right = a.length - 1, result = -1;
    while (left <= right) {
        int mid = (left + right) / 2;
        if (a[mid] == key) {
            result = mid;
            right = mid - 1; // tiếp tục tìm bên trái
        } else if (a[mid] > key) {
            right = mid - 1;
        } else {
            left = mid + 1;
        }
    }
    return result;
}

// Tìm vị trí xuất hiện cuối cùng
public static int binarySearchLast(int[] a, int key) {
    int left = 0, right = a.length - 1, result = -1;
    while (left <= right) {
        int mid = (left + right) / 2;
        if (a[mid] == key) {
            result = mid;
            left = mid + 1; // tiếp tục tìm bên phải
        } else if (a[mid] > key) {
            right = mid - 1;
        } else {
            left = mid + 1;
        }
    }
    return result;
}

    public static void printAllIndices(int[] a, int key) {
    int first = binarySearchFirst(a, key);
    int last = binarySearchLast(a, key);

    if (first == -1) {
        System.out.println("Value " + key + " not found in array.");
    } else {
        System.out.print("Value " + key + " found at indices: ");
        for (int i = first; i <= last; i++) {
            System.out.print(i + " ");
        }
        System.out.println();
    }
}

    public static void main(String[] args) {
        int n = inputSizeOfArray();
        int bound = validateInput("Enter maximum random value (bound): ");

        // Sinh ngẫu nhiên mảng
        int[] a = generateRandomArray(n, bound);

        // Sắp xếp bằng Bubble Sort
        sortByBubbleSort(a);

        System.out.print("Sorted Array: ");
        displayArray(a);
        while(true){
            
        
        int key = validateInput("Enter search value: ");
        int foundIndex = binarySearch(a, key);

        if (foundIndex == -1) {
            System.out.println("Value " + key + " not found in array.");
        } else {
            System.out.println("Value " + key + " found at index " + foundIndex);
        }
        }
    }
}
