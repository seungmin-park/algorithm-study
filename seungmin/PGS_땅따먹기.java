public class PGS_땅따먹기 {
    class Solution {
        int solution(int[][] land) {
            int answer = 0;
            int[][] dp = new int[land.length][4];
            dp[0][0] = land[0][0];
            dp[0][1] = land[0][1];
            dp[0][2] = land[0][2];
            dp[0][3] = land[0][3];

            for (int col = 1; col < land.length; col++) {
                dp[col][0] = land[col][0] + Math.max(dp[col - 1][3], Math.max(dp[col - 1][1], dp[col - 1][2]));
                dp[col][1] = land[col][1] + Math.max(dp[col - 1][3], Math.max(dp[col - 1][0], dp[col - 1][2]));
                dp[col][2] = land[col][2] + Math.max(dp[col - 1][3], Math.max(dp[col - 1][1], dp[col - 1][0]));
                dp[col][3] = land[col][3] + Math.max(dp[col - 1][0], Math.max(dp[col - 1][1], dp[col - 1][2]));
            }

            for (int row = 0; row < 4; row++) {
                answer = Math.max(answer, dp[land.length - 1][row]);
            }
            return answer;
        }
    }
}
