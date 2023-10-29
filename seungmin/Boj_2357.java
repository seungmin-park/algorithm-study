import java.io.*;
import java.util.*;

public class Boj_2357 {
    static class Node {
        int min, max;

        Node(int min, int max) {
            this.min = min;
            this.max = max;
        }
    }

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static Node[] nodes;
    static int[] arr;
    static int N, M;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[N + 1];
        nodes = new Node[N * 4];
        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        init(1, 1, N);

        for (int i = 1; i <= M; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            Node ans = get(1, 1, N, start, end);
            sb.append(ans.min).append(" ").append(ans.max).append("\n");
        }

        System.out.println(sb);
    }

    static Node init(int node, int left, int right) {
        if (left == right) {
            return nodes[node] = new Node(arr[left], arr[left]);
        }

        Node leftNode = init(node * 2, left, (left + right) / 2);
        Node rightNode = init(node * 2 + 1, (left + right) / 2 + 1, right);

        return nodes[node] = new Node(Math.min(leftNode.min, rightNode.min), Math.max(leftNode.max, rightNode.max));
    }

    static Node get(int node, int start, int end, int left, int right) {
        if (left > end || right < start) {
            return new Node(Integer.MAX_VALUE, Integer.MIN_VALUE);
        }

        if (left <= start && end <= right) {
            return nodes[node];
        }

        Node leftNode = get(node * 2, start, (start + end) / 2, left, right);
        Node rightNode = get(node * 2 + 1, (start + end) / 2 + 1, end, left, right);

        return new Node(Math.min(leftNode.min, rightNode.min), Math.max(leftNode.max, rightNode.max));
    }
}
