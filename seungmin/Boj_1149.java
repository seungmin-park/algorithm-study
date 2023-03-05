import java.util.*;
import java.io.*;

public class Boj_1149 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int[] idx = new int[4];
    static int[][] dp;
    static int[][] cost;
    static int N;

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        cost = new int[N + 1][4];
        dp = new int[N + 1][4];

        for(int col = 1; col <=N; col++){
            st = new StringTokenizer(br.readLine());
            for(int row = 1; row <= 3; row++){
                cost[col][row] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i = 1; i <=3; i++){
            dp[1][i] = cost[1][i];
            idx[i] = i;
        }

        for(int i = 2; i <=N; i++){
            dp[i][1] = Math.min(dp[i -1][2],dp[i -1][3]) + cost[i][1];
            dp[i][2] = Math.min(dp[i -1][1],dp[i -1][3]) + cost[i][2];
            dp[i][3] = Math.min(dp[i -1][1],dp[i -1][2]) + cost[i][3];
        }

        int min = Math.min(dp[N][1], Math.min(dp[N][2], dp[N][3]));
        System.out.println(min);
    }
}
