import java.io.*;

public class Boj_2156 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int[] dp, grape;
    static int n;

    public static void main(String[] args) throws IOException {
        n = Integer.parseInt(br.readLine());
        dp = new int[n + 1];
        grape = new int[n + 1];

        for(int i = 1; i <= n; i++){
            grape[i] = Integer.parseInt(br.readLine());
        }

        if(n == 1){
            System.out.println(grape[n]);
            return;
        }

        dp[1] = grape[1];
        dp[2] = grape[1] + grape[2];
        
        for(int i = 3; i <= n; i++){
            int cand1 = dp[i - 2] + grape[i];
            int cand2 = dp[i - 3] + grape[i - 1] + grape[i];
            dp[i] = Math.max(cand1, cand2);
            dp[i] = Math.max(dp[i - 1], dp[i]);
        }

        System.out.println(dp[n]);
    }
}
