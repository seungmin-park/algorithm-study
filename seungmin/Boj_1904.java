import java.io.*;

public class Boj_1904 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int[] dp = new int[1_000_001];
    static int N, ans;

    public static void main(String[] args) throws IOException {
        dp[1] = 1;
        dp[2] = 2;

        for(int i = 3; i <= 1_000_000; i++){
            dp[i] = ((dp[i -2] + dp[i -1]) % 15_746);
        }
        N = Integer.parseInt(br.readLine());

        System.out.println(dp[N]);
    }
}
