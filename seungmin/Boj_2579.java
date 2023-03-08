import java.io.*;

public class Boj_2579 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int[][] dp;
    static int[] stairs;
    static int N;

    public static void main(String[] args) throws IOException{
        N = Integer.parseInt(br.readLine());
        dp = new int[N + 1][3];
        stairs = new int[N + 1];

        for(int i =1 ; i <=N; i++){
            stairs[i] = Integer.parseInt(br.readLine());
        }
        if(N == 1){
            System.out.println(stairs[1]);
            return;
        }
        dp[1][1] = stairs[1];
        dp[2][1] = stairs[1] + stairs[2];
        dp[2][2] = stairs[2];
        for(int i = 3; i <= N; i++){
            dp[i][1] = dp[i -1][2] + stairs[i];
            dp[i][2] += Math.max(dp[i - 2][1], dp[i - 2][2]) + stairs[i];
        }

        System.out.println(Math.max(dp[N][1], dp[N][2]));
    }
}
