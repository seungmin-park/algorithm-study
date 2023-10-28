import java.io.*;
import java.util.*;

public class Boj_10868 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static int[] arr, tree;
    static int N, M;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[N + 1];
        tree = new int[N * 4];
        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        init(1, 1, N);
        for (int i = 1; i <= M; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());

            sb.append(min(1, 1, N, from, to)).append("\n");
        }

        System.out.println(sb);
    }

    static int init(int node, int left, int right) {
        if (left == right) {
            return tree[node] = arr[left];
        }

        int leftChild = init(node * 2, left, (left + right) / 2);
        int rightChild = init(node * 2 + 1, (left + right) / 2 + 1, right);

        return tree[node] = Math.min(leftChild, rightChild);
    }

    static int min(int node, int start, int end, int left, long right) {
        if (left > end || right < start) {
            return Integer.MAX_VALUE;
        }
        if (left <= start && end <= right) {
            return tree[node];
        }

        int leftMin = min(node * 2, start, (start + end) / 2, left, right);
        int rightMin = min(node * 2 + 1, (start + end) / 2 + 1, end, left, right);
        return Math.min(leftMin, rightMin);
    }
}
