import java.io.*;
import java.util.*;

public class Boj_14501 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int[][] schedule;
    static int[] dp;
    static int N, ans = Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        schedule = new int[2][N + 1];
        dp = new int[N + 2];
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            int time = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            schedule[0][i] = time;
            schedule[1][i] = cost;
        }

        for (int i = 1; i <= N; i++) {
            int deadLine = i + schedule[0][i];
            if (deadLine <= N + 1) {
                dp[deadLine] = Math.max(dp[i] + schedule[1][i], dp[deadLine]);
            }
            dp[i + 1] = Math.max(dp[i], dp[i + 1]);

        }

        for (int d : dp) {
            ans = Math.max(ans, d);
        }

        System.out.println(ans);
    }
}
