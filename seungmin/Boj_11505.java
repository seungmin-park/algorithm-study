import java.io.*;
import java.util.*;

public class Boj_11505 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static long[] tree;
    static int[] arr;
    static int N, M, K;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        arr = new int[N + 1];
        tree = new long[N * 4];
        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        init(1, 1, N);

        for (int i = 1; i <= M + K; i++) {
            st = new StringTokenizer(br.readLine());
            int option = Integer.parseInt(st.nextToken());
            int idx = Integer.parseInt(st.nextToken());
            int value = Integer.parseInt(st.nextToken());
            if (option == 1) {
                update(1, 1, N, idx, value);
                arr[idx] = value;
                continue;
            }
            sb.append(multiply(1, 1, N, idx, value)).append("\n");
        }

        System.out.println(sb);
    }

    static long init(int node, int left, int right) {
        if (left == right) {
            return tree[node] = arr[left];
        }

        long leftChild = init(node * 2, left, (left + right) / 2);
        long rightChild = init(node * 2 + 1, (left + right) / 2 + 1, right);

        return tree[node] = leftChild * rightChild % 1_000_000_007;
    }

    static long update(int node, int left, int right, int idx, int value) {
        if (idx < left || right < idx) {
            return tree[node];
        }
        if (left == right) {
            return tree[node] = value;
        }

        long leftChild = update(node * 2, left, (left + right) / 2, idx, value);
        long rightChild = update(node * 2 + 1, (left + right) / 2 + 1, right, idx, value);
        return tree[node] = leftChild * rightChild % 1_000_000_007;
    }

    static long multiply(int node, int left, int right, int start, int end) {
        if (right < start || end < left) {
            return 1;
        }
        if (start <= left && right <= end) {
            return tree[node];
        }

        long leftChild = multiply(node * 2, left, (left + right) / 2, start, end);
        long rightChild = multiply(node * 2 + 1, (left + right) / 2 + 1, right, start, end);

        return leftChild * rightChild % 1_000_000_007;
    }
}
