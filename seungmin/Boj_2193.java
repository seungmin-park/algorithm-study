import java.io.*;

public class Boj_2193 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static long[][] dp = new long[2][91];
    static int N;

    public static void main(String[] args) throws IOException {
        dp[0][1] = 0;
        dp[1][1] = 1;
        dp[0][2] = 1;
        dp[1][2] = 0;

        for(int i = 3; i <= 90; i++){
            dp[0][i] = dp[0][i - 1] + dp[1][i - 1];
            dp[1][i] = dp[0][i - 1];
        }

        N = Integer.parseInt(br.readLine());
        System.out.println(dp[0][N] + dp[1][N]);
    }
}
