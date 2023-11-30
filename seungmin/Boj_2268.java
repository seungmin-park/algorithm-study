import java.io.*;
import java.util.*;

public class Boj_2268 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static long[] arr, tree;
    static int N, M;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new long[N + 1];
        tree = new long[N * 4];

        init(1, 1, N);
        for (int i = 1; i <= M; i++) {
            st = new StringTokenizer(br.readLine());
            int option = Integer.parseInt(st.nextToken());
            int idx = Integer.parseInt(st.nextToken());
            long value = Long.parseLong(st.nextToken());
            if (option == 1) {
                update(1, 1, N, idx, value - arr[idx]);
                arr[idx] = value;
                continue;
            }
            if (option == 0) {
                sb.append(sum(1, 1, N, (int) Math.min(idx, value), (int) Math.max(idx, value))).append("\n");
            }
        }

        System.out.println(sb);
    }

    static long init(int node, int start, int end) {
        if (start == end) {
            return tree[node] = arr[start];
        }
        long leftChild = init(node * 2, start, (start + end) / 2);
        long rightChild = init(node * 2 + 1, (start + end) / 2 + 1, end);

        return tree[node] = leftChild + rightChild;
    }

    static long sum(int node, int start, int end, int left, long right) {
        if (left > end || right < start) {
            return 0;
        }
        if (left <= start && end <= right) {
            return tree[node];
        }

        long leftSum = sum(node * 2, start, (start + end) / 2, left, right);
        long rightSum = sum(node * 2 + 1, (start + end) / 2 + 1, end, left, right);
        return leftSum + rightSum;
    }

    static void update(int node, int start, int end, int idx, long differ) {
        if (idx < start || end < idx) {
            return;
        }
        tree[node] += differ;

        if (start != end) {
            update(node * 2, start, (start + end) / 2, idx, differ);
            update(node * 2 + 1, (start + end) / 2 + 1, end, idx, differ);
        }
    }
}
