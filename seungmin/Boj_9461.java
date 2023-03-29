import java.io.*;
import java.util.*;

public class Boj_9461 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static long[] dp = new long[101];
    static int T, N;

    public static void main(String[] args) throws IOException {
        dp[1] = 1;
        dp[2] = 1;
        dp[3] = 1;
        dp[4] = 2;
        dp[5] = 2;
        for(int i = 6; i <=100; i++){
            dp[i] = dp[i - 1] + dp[i - 5];
        }
        T = Integer.parseInt(br.readLine());
        for(int i = 1; i <= T; i++){
            N = Integer.parseInt(br.readLine());
            sb.append(dp[N]).append("\n");
        }

        System.out.println(sb);
    }
}
