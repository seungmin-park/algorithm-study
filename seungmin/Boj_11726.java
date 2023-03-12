import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Boj_11726{
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int[] dp = new int[1001];
    static int N;

    public static void main(String[] args) throws IOException{
        N = Integer.parseInt(br.readLine());
        dp[1] = 1;
        dp[2] = 2;

        for(int i = 3; i <=N; i++){
            dp[i] = (dp[i - 2] + dp[i -1]) % 10007;
        }

        System.out.println(dp[N]);
    }
}