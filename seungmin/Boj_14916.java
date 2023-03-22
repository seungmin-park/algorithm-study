import java.io.*;

public class Boj_14916 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int[] dp = new int[100_001];
    static int n;

    public static void main(String[] args) throws IOException {
        n = Integer.parseInt(br.readLine());
        dp[0] = 500_01;
        dp[1] = 500_01;
        dp[2] = 1;
        dp[3] = 500_01;
        dp[4] = 2;
        dp[5] = 1;
        for (int i = 6; i <= 100_000; i++) {
            dp[i] = Math.min(dp[i - 5], dp[i - 2]) + 1;
        }

        System.out.println(dp[n] == 500_01 ? -1 : dp[n]);
    }
}
