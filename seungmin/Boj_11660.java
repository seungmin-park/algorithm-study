import java.io.*;
import java.util.*;

public class Boj_11660 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static int[][] numbers, dp;
    static int N, M;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        numbers = new int[N + 1][N + 1];
        dp = new int[N + 1][N + 1];

        for (int col = 1; col <= N; col++) {
            st = new StringTokenizer(br.readLine());
            for (int row = 1; row <= N; row++) {
                numbers[col][row] = Integer.parseInt(st.nextToken());
                dp[col][row] = numbers[col][row];
            }
        }

        for (int col = 1; col <= N; col++) {
            for (int row = 1; row <= N; row++) {
                dp[col][row] += dp[col][row - 1];
            }
        }

        for (int t = 1; t <= M; t++) {
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());
            if (x1 == x2 && y1 == y2) {
                sb.append(numbers[x1][y1]);
            } else {
                int sum = 0;
                for (int x = x1; x <= x2; x++) {
                    sum += dp[x][y2] - dp[x][y1 - 1];
                }
                sb.append(sum);
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}
