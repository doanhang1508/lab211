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
  static Map<Integer, Long> memo = new HashMap<>();

    // Hàm đệ quy có nhớ
    public static long fibonacci(int n) {
        if (n == 0) return 0;
        if (n == 1) return 1;

        if (memo.containsKey(n)) return memo.get(n);

        long value = fibonacci(n - 1) + fibonacci(n - 2);
        memo.put(n, value);

        return value;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter n: ");
        int n = sc.nextInt();

        // ✅ In ra giá trị Fibonacci thứ n
        long result = fibonacci(n);
        System.out.println("\nFibonacci(" + n + ") = " + result);

        // ✅ Tạo mảng chứa tất cả các số Fibonacci từ 0 đến n
        long[] fib = new long[n + 1];
        for (int i = 0; i <= n; i++) {
            fib[i] = fibonacci(i);
        }

        // ✅ In ra toàn bộ dãy Fibonacci đến n
        System.out.println("\n=== Fibonacci Sequence up to n ===");
        for (long f : fib) {
            System.out.print(f + " ");
        }

        // ✅ Tìm số lớn nhất trong dãy để xác định phạm vi cần xét
        long max = fib[n];

        // ✅ In ra các số KHÔNG thuộc dãy Fibonacci trong khoảng 0 → max
        System.out.println("\n\n=== Non-Fibonacci numbers up to " + max + " ===");

        for (long i = 0; i <= max; i++) {
            boolean isFibo = false;
            for (long f : fib) {
                if (f == i) {
                    isFibo = true;
                    break;
                }
            }
            if (!isFibo) System.out.print(i + " ");
        }

        System.out.println("\n=== End ===");
    }
}
