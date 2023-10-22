import java.io.*;
import java.util.*;

public class Boj_25953 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static int[][] dp;
    static int n, t, m, s, e;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        t = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        dp = new int[t + 1][n];
        for (int i = 0; i <= t; i++) {
            Arrays.fill(dp[i], 123_456_789);
        }

        st = new StringTokenizer(br.readLine());
        s = Integer.parseInt(st.nextToken());
        e = Integer.parseInt(st.nextToken());
        dp[0][s] = 0;

        for (int T = 0; T < t; T++) {
            System.arraycopy(dp[T], 0, dp[T + 1], 0, n);
            for (int M = 0; M < m; M++) {
                st = new StringTokenizer(br.readLine());
                int from = Integer.parseInt(st.nextToken());
                int to = Integer.parseInt(st.nextToken());
                int dist = Integer.parseInt(st.nextToken());
                dp[T + 1][from] = Math.min(dp[T + 1][from], dp[T][to] + dist);
                dp[T + 1][to] = Math.min(dp[T + 1][to], dp[T][from] + dist);
            }
        }

        bw.write(sb.append(dp[t][e] == 123_456_789 ? -1 : dp[t][e]).toString());
        bw.flush();
    }
}
