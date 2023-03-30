import java.io.*;
import java.util.*;

public class Boj_4097 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static int[] dp, numbers;
    static int N;

    public static void main(String[] args) throws IOException {
        while((N = Integer.parseInt(br.readLine())) != 0){
            int ans = Integer.MIN_VALUE;
            numbers = new int[N + 1];
            dp = new int[N + 1];

            for(int i = 1; i <= N; i++){
                numbers[i] = Integer.parseInt(br.readLine());
            }

            dp[1] = numbers[1];
            for(int i = 1; i <=N; i++){
                if(dp[i - 1] < 0){
                    dp[i] = numbers[i];
                }else{
                    dp[i] = dp[i - 1] + numbers[i];
                }
                ans = Math.max(ans, dp[i]);
            }
            sb.append(ans).append("\n");
        }

        System.out.println(sb);
    }
}
