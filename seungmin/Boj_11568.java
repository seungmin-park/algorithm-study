import java.io.*;
import java.util.*;

public class Boj_11568 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int[] dp;
    static int N, ans = 1;

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());

        dp = new int[N];
        dp[0] = Integer.parseInt(st.nextToken());
        for (int i = 1; i < N; i++) {
            int number = Integer.parseInt(st.nextToken());
            if(dp[ans - 1] < number){
                dp[ans] = number;
                ans++;
            }else{
                dp[binarySearch(0, ans, number)] = number;
            }
        }

        System.out.println(ans);
    }

    static int binarySearch(int L, int R, int target){
        while(L <= R){
            int M = (L + R) / 2;
            if(dp[M] >= target){
                R = M - 1;
            }else if(dp[M] < target){
                L = M + 1;
            }
        }

        return L;
    }
}
