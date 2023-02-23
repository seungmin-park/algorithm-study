import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Boj_1003 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static int[][] dp = new int[2][41];
    static int T;

    public static void main(String[] args) throws IOException {
        dp[0][0] = 1;
        dp[0][1] = 0;
        dp[1][0] = 0;
        dp[1][1] = 1;

        for (int i = 2; i <= 40; i++) {
            dp[0][i] = dp[0][i - 2] + dp[0][i - 1];
            dp[1][i] = dp[1][i - 2] + dp[1][i - 1];
        }

        T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            int idx = Integer.parseInt(br.readLine());
            sb.append(dp[0][idx]).append(" ").append(dp[1][idx]).append("\n");
        }

        System.out.println(sb.toString());
    }
}
