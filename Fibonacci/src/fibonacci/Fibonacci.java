/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package fibonacci;

/**
 *
 * @author Thanh Hang
 */
public class Fibonacci {

    public static long fibonacci(int n) {
        if (n == 0) return 0;       // Trường hợp cơ sở
        if (n == 1) return 1;       // Trường hợp cơ sở
        return fibonacci(n - 1) + fibonacci(n - 2); // Gọi đệ quy
    }

    public static void main(String[] args) {
        System.out.println("=== Fibonacci Sequence (First 45 Numbers) ===");

        // In ra 45 số Fibonacci đầu tiên
        for (int i = 0; i < 45; i++) {
            System.out.println(fibonacci(i));
        }

        System.out.println("\n=== End of Sequence ===");
    }
}
