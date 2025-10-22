/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package graph;

import java.util.Scanner;

/**
 *
 * @author Thanh Hang
 */
public class Graph {

     private int[][] adjMatrix;
    private int vertexCount;

    public Graph(int vertexCount) {
        this.vertexCount = vertexCount;
        adjMatrix = new int[vertexCount + 1][vertexCount + 1]; // index từ 1
    }

    public void addEdge(int i, int j) {
        adjMatrix[i][j] = 1;
        adjMatrix[j][i] = 1;
    }

    public boolean isEdge(int i, int j) {
        return adjMatrix[i][j] == 1;
    }

    // In ma trận kề (tuỳ chọn, giúp kiểm tra)
    public void printMatrix() {
        System.out.println("\nAdjacency matrix:");

        // In tiêu đề cột
        System.out.print("    "); // chừa chỗ cho tiêu đề hàng
        for (int i = 1; i <= vertexCount; i++) {
            System.out.printf("%3d", i);
        }
        System.out.println();

        // In từng hàng
        for (int i = 1; i <= vertexCount; i++) {
            System.out.printf("%3d ", i); // in tiêu đề hàng
            for (int j = 1; j <= vertexCount; j++) {
                System.out.printf("%3d", adjMatrix[i][j]);
            }
            System.out.println();
        }
    }
}

