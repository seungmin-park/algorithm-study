import java.io.*;
import java.util.*;

public class Boj_14465 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int[] arr, sum;
    static int N, K, B, ans = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());

        arr = new int[N + 1];
        sum = new int[N + 1];
        for (int i = 1; i <= B; i++) {
            int idx = Integer.parseInt(br.readLine());
            arr[idx] = 1;
        }

        for (int i = 1; i <= N; i++) {
            sum[i] = sum[i - 1] + arr[i];
        }

        for (int i = K; i <= N; i++) {
            ans = Math.min(ans, sum[i] - sum[i - K + 1]);
        }

        System.out.println(ans);
    }
}
