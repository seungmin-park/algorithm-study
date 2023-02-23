import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Boj_24416 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static int[] dp = new int[41];
    static int n;

    public static void main(String[] args) throws IOException {
        n = Integer.parseInt(br.readLine());

        dp[1] = 1;
        dp[2] = 1;
        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 2] + dp[i - 1];
        }

        sb.append(dp[n]).append(" ").append(n - 2);
        System.out.println(sb);
    }
}
