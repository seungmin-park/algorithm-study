import java.io.*;
import java.util.*;

public class Boj_11441 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static int[] arr, sum;
    static int N, M;

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        arr = new int[N + 1];
        sum = new int[N + 1];

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        sum[1] = arr[1];
        for (int i = 1; i <= N; i++) {
            sum[i] = sum[i - 1] + arr[i];
        }

        M = Integer.parseInt(br.readLine());
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            sb.append(sum[end] - sum[start] + arr[start]).append("\n");
        }

        System.out.println(sb);
    }
}
