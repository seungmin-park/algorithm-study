import java.io.*;
import java.util.*;

public class Boj_1932 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int[][] dp, triangle;
    static int n;

    public static void main(String[] args) throws IOException {
        n = Integer.parseInt(br.readLine());
        triangle = new int[n + 1][n + 1];
        dp = new int[n + 1][n + 1];

        for (int col = 1; col <= n; col++) {
            st = new StringTokenizer(br.readLine());
            for (int row = 1; row <= col; row++) {
                triangle[col][row] = Integer.parseInt(st.nextToken());
            }
        }

        for (int col = 1; col <= n; col++) {
            dp[col][1] = dp[col - 1][1] + triangle[col][1];
        }

        for (int col = 2; col <= n; col++) {
            for (int row = 2; row <= col; row++) {
                dp[col][row] = 
                Math.max(dp[col - 1][row] + triangle[col][row],dp[col - 1][row - 1] + triangle[col][row]);
            }
        }

        int max = Integer.MIN_VALUE;
        for (int cand : dp[n]) {
            max = Math.max(max, cand);
        }
        System.out.println(max);
    }
}
