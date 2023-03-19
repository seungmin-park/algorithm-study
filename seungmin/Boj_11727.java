import java.io.*;

public class Boj_11727 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static long[] dp;
    static int n;

    public static void main(String[] args) throws IOException {
        n = Integer.parseInt(br.readLine());
        dp = new long[100_1];
        dp[1] = 1;
        dp[2] = 3;
        for (int i = 3; i <= 100_0; i++) {
            dp[i] = (dp[i - 1] + dp[i - 2] * 2) % 10_007;
        }

        System.out.println(dp[n]);
    }
}
