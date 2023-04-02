import java.io.*;
import java.util.*;

public class Boj_11055 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int[] dp;
    static int[] A;
    static int N, ans = Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        A = new int[N + 1];
        dp = new int[N + 1];
        st = new StringTokenizer(br.readLine());

        for(int i = 1; i <= N; i++){
            A[i] = Integer.parseInt(st.nextToken());
            dp[i] = A[i];
        }

        for(int i = 1; i <= N; i++){
            for(int j = 1; j < i; j++){
                if(A[i] > A[j]){
                    dp[i] = Math.max(dp[i], dp[j] + A[i]);
                }
            }
            ans = Math.max(ans, dp[i]);
        }
        System.out.println(ans);
    }
}
