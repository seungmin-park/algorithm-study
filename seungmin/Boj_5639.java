import java.io.*;

public class Boj_5639 {
    static class Node {
        Node left;
        Node right;
        int value;

        void insert(int value) {
            if (value < this.value) {
                if (left == null) {
                    Node left = new Node();
                    left.value = value;
                    this.left = left;
                } else {
                    left.insert(value);
                }
            } else {
                if (right == null) {
                    Node right = new Node();
                    right.value = value;
                    this.right = right;
                } else {
                    right.insert(value);
                }
            }
        }
    }

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static Node root = new Node();

    public static void main(String[] args) throws IOException {
        root.value = Integer.parseInt(br.readLine());

        while (true) {
            String next = br.readLine();
            if (next == null) {
                break;
            }
            int value = Integer.parseInt(next);
            root.insert(value);
        }
        dfs(root);

        System.out.println(sb);
    }

    static void dfs(Node start) {
        if (start == null) {
            return;
        }
        dfs(start.left);
        dfs(start.right);
        sb.append(start.value);
        sb.append("\n");
    }
}
