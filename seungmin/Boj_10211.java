import java.io.*;
import java.util.*;

public class Boj_10211 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static int[] arr, sum;
    static int N, T, ans;

    public static void main(String[] args) throws IOException {
        T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            ans = Integer.MIN_VALUE;
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

            for (int i = 1; i <= N; i++) {
                for (int j = i; j <= N; j++) {
                    ans = Math.max(ans, sum[j] - sum[i] + arr[i]);
                }
            }
            sb.append(ans).append("\n");
        }

        System.out.println(sb);
    }
}
