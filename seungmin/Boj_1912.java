import java.io.*;
import java.util.*;

public class Boj_1912 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int[] dp, numbers;
    static int N, ans = Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        numbers = new int[N + 1];
        dp = new int[N + 1];

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }

        dp[1] = numbers[1];
        for (int i = 2; i <= N; i++) {
            if (dp[i - 1] < 0) {
                dp[i] = numbers[i];
            } else {
                dp[i] = dp[i - 1] + numbers[i];
            }
        }
        for (int i = 1; i <= N; i++) {
            ans = Math.max(dp[i], ans);
        }

        System.out.println(ans);
    }
}
