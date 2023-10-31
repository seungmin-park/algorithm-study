import java.io.*;
import java.util.*;

public class Boj_1275 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static long[] arr, tree;
    static int N, Q;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        Q = Integer.parseInt(st.nextToken());

        arr = new long[N + 1];
        tree = new long[N * 4];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            arr[i] = Long.parseLong(st.nextToken());
        }

        init(1, 1, N);

        for (int i = 1; i <= Q; i++) {
            st = new StringTokenizer(br.readLine());
            int left = Integer.parseInt(st.nextToken());
            int right = Integer.parseInt(st.nextToken());
            int idx = Integer.parseInt(st.nextToken());
            long value = Integer.parseInt(st.nextToken());
            sb.append(sum(1, 1, N, Math.min(left, right), Math.max(left, right))).append("\n");
            update(1, 1, N, idx, value - arr[idx]);
            arr[idx] = value;
        }

        System.out.println(sb);
    }

    static long init(int node, int left, int right) {
        if (left == right) {
            return tree[node] = arr[left];
        }

        long leftChild = init(node * 2, left, (left + right) / 2);
        long rightChild = init(node * 2 + 1, (left + right) / 2 + 1, right);

        return tree[node] = leftChild + rightChild;
    }

    static long sum(int node, int left, int right, int start, int end) {
        if (start > right || end < left) {
            return 0;
        }

        if (start <= left && right <= end) {
            return tree[node];
        }

        long leftChild = sum(node * 2, left, (left + right) / 2, start, end);
        long rightChild = sum(node * 2 + 1, (left + right) / 2 + 1, right, start, end);
        return leftChild + rightChild;
    }

    static void update(int node, int left, int right, int idx, long differ) {
        if (idx < left || right < idx) {
            return;
        }

        tree[node] += differ;
        if (left != right) {
            update(node * 2, left, (left + right) / 2, idx, differ);
            update(node * 2 + 1, (left + right) / 2 + 1, right, idx, differ);
        }
    }
}
