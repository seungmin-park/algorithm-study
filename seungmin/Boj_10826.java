import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

/**
 * 출력 범위 생각하기
 * 1차 시도: int
 * 2차 시도: long
 * 3차 시도: BigInteger
 */
public class Boj_10826 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BigInteger[] dp = new BigInteger[10_001];
    static int N;

    public static void main(String[] args) throws IOException{
        dp[0] = BigInteger.valueOf(0);
        dp[1] = BigInteger.valueOf(1);
        dp[2] = BigInteger.valueOf(1);

        for(int i = 3; i <= 10_000; i++){
            dp[i] = dp[i -2].add(dp[i -1]);
        }

        N = Integer.parseInt(br.readLine());
        System.out.println(dp[N].toString());
    }
}
