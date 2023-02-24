import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Boj_10870 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int[] dp = new int[21];
    static int n;

    public static void main(String[] args) throws IOException {
        dp[0] = 0;
        dp[1] = 1;

        for (int i = 2; i <= 20; i++) {
            dp[i] = dp[i - 2] + dp[i - 1];
        }

        System.out.println(dp[Integer.parseInt(br.readLine())]);
    }
}
