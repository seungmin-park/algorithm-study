import java.io.*;
import java.util.StringTokenizer;

public class Boj_14929 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static long[] sum;
    static long ans;
    static int[] arr;
    static int N;

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        arr = new int[N + 1];
        sum = new long[N + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 1; i <= N; i++) {
            sum[i] = sum[i - 1] + arr[i];
        }

        for (int i = 1; i < N; i++) {
            ans += arr[i] * (sum[N] - sum[i]);
        }

        System.out.println(ans);
    }
}
