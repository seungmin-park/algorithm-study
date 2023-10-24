import java.io.*;
import java.util.*;

public class Boj_12847 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int[] arr;
    static long[] sum;
    static int N, M;
    static long ans;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[N + 1];
        sum = new long[N + 1];

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 1; i <= N; i++) {
            sum[i] = sum[i - 1] + arr[i];
        }

        ans = sum[M];
        for (int i = M + 1; i <= N; i++) {
            ans = Math.max(ans, sum[i] - sum[i - M]);
        }

        System.out.println(ans);
    }
}
