/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package graph;

import java.util.Scanner;

/**
 *
 * @author Thanh Hang
 */
public class Main {
      public static void main(String[] args) {
          
        int n = Validation.inputInteger("Enter number of vertices: ", 1, 100);
        Graph graph = new Graph(n);

        int e = Validation.inputInteger("Enter number of edges: ", 0, n * (n - 1) / 2);

        for (int k = 1; k <= e; k++) {
            System.out.println("Edge " + k + ":");
            int u = Validation.inputInteger("  Enter start vertex: ", 1, n);
            int v = Validation.inputInteger("  Enter end vertex: ", 1, n);
            graph.addEdge(u, v);
        }

        // ✅ In ma trận kề trước khi kiểm tra cạnh
        graph.printMatrix();

        // Kiểm tra 2 đỉnh có là cạnh không
        int start = Validation.inputInteger("Enter the start point: ", 1, n);
        int end = Validation.inputInteger("Enter the end point: ", 1, n);

        if (graph.isEdge(start, end)) {
            System.out.println("This is an edge");
        } else {
            System.out.println("This is not an edge");
        }
    }
      
//        // Tạo đồ thị có 5 đỉnh
//        Graph graph = new Graph(5);
//
//        // Thêm các cạnh (ví dụ trong đề)
//        graph.addEdge(1, 3);
//        graph.addEdge(2, 5);
//
//        // Giao diện nhập dữ liệu
//        int start = Validation.inputInteger("Enter the start point: ", 1, 5);
//        int end = Validation.inputInteger("Enter the end point: ", 1, 5);
//
//        if (graph.isEdge(start, end)) {
//            System.out.println("This is an edge");
//        } else {
//            System.out.println("This is not an edge");
//        }
    }

