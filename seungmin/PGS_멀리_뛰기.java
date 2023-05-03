public class PGS_멀리_뛰기 {
    class Solution {
        public long solution(int n) {
            long[] dp = new long[2_001];
            dp[1] = 1;
            dp[2] = 2;
            for (int i = 3; i <= 2_000; i++) {
                dp[i] = (dp[i - 1] + dp[i - 2]) % 1_234_567;
            }
            return dp[n];
        }
    }
}
