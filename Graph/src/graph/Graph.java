/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package graph;

/**
 *
 * @author Thanh Hang
 */
public class Graph {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
      private final boolean[][] adj; // ma trận kề 1..n (bỏ hàng/ cột 0)
    private final int n;

    public Graph(int vertexCount) {
        if (vertexCount < 1) {
            throw new IllegalArgumentException("vertexCount >= 1");
        }
        this.n = vertexCount;
        this.adj = new boolean[n + 1][n + 1];
    }

    private void validate(int v) {
        if (v < 1 || v > n) {
            throw new IndexOutOfBoundsException("vertex out of range");
        }
    }

    // undirected edge
    public void addEdge(int i, int j) {
        validate(i);
        validate(j);
        adj[i][j] = true;
        adj[j][i] = true;
    }

    public boolean isEdge(int i, int j) {
        validate(i);
        validate(j);
        return adj[i][j]; // đối xứng nên chỉ cần một phía
    }

    public void printMatrix() {
        // header cột
        System.out.print("    ");
        for (int c = 1; c <= n; c++) {
            System.out.printf("%3d", c);
        }
        System.out.println();

        // từng dòng
        for (int i = 1; i <= n; i++) {
            System.out.printf("%3d|", i);           // nhãn dòng
            for (int j = 1; j <= n; j++) {
                int bit = adj[i][j] ? 1 : 0;
                System.out.printf("%3d", bit);
            }
            System.out.println();
        }
    }
    // In danh sách kề theo từng đỉnh (1..n)

    public void printAdjacencyList() {
        for (int i = 1; i <= n; i++) {
            System.out.print(i + ": ");
            boolean first = true;
            for (int j = 1; j <= n; j++) {
                if (adj[i][j]) {
                    if (!first) {
                        System.out.print(", ");
                    }
                    System.out.print(j);
                    first = false;
                }
            }
            if (first) {
                System.out.print("(none)");
            }
            System.out.println();
        }
    }

    public int degree(int v) {
        validate(v); // dùng lại validate(int v) của bạn nếu có
        int deg = 0;
        for (int j = 1; j <= n; j++) {
            if (adj[v][j]) {
                deg += (v == j ? 2 : 1);
            }
        }
        return deg;
    }

// In bậc cho mọi đỉnh
    public void printDegrees() {
        for (int i = 1; i <= n; i++) {
            System.out.printf("deg(%d) = %d%n", i, degree(i));
        }
    }
    public void printAdjListWithDegree() {
    for (int i = 1; i <= n; i++) {
        StringBuilder sb = new StringBuilder();
        int deg = 0;
        for (int j = 1; j <= n; j++) {
            if (adj[i][j]) {
                if (!sb.isEmpty()) sb.append(", ");
                sb.append(j);
                deg += (i == j ? 2 : 1);
            }
        }
        System.out.println(i + ": " + (sb.isEmpty() ? "(none)" : sb) + "  |  deg=" + deg);
    }
}

    public static void main(String[] args) {
        Graph graph = new Graph(6);
        graph.addEdge(1, 4);
        graph.addEdge(2, 4);
        graph.addEdge(2, 5);
        graph.addEdge(3, 5);
        graph.addEdge(4, 5);
        graph.printMatrix();

        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("Enter the start point:");
            int start = scanner.nextInt();

            System.out.println("Enter the end point:");
            int end = scanner.nextInt();

            boolean edge = graph.isEdge(start, end);
            System.out.println("This is" + (edge ? " an edge" : " not an edge"));
        } catch (Exception e) {
            // nếu nhập sai kiểu hoặc ngoài range thì in cho gọn
            System.out.println("Invalid input");
        }
    }
    }
    
}

