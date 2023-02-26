import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Boj_15988 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static long[] dp = new long[1_000_001];
    static int T, n;

    public static void main(String[] args) throws IOException {
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 4;

        for (int i = 4; i <= 1_000_000; i++) {
            dp[i] = (dp[i - 3] + dp[i - 2] + dp[i - 1]) % 1_000_000_009;
        }

        T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            int idx = Integer.parseInt(br.readLine());
            sb.append(dp[idx]).append("\n");
        }

        System.out.println(sb.toString());
    }
}
