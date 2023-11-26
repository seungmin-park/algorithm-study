import java.io.*;
import java.util.*;

public class Boj_29700 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int[][] map, sum;
    static int N, M, K, ans;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        map = new int[N + 1][M + 1];
        sum = new int[N + 1][M + 1];
        for (int i = 1; i <= N; i++) {
            String target = br.readLine();
            for (int j = 0; j < M; j++) {
                map[i][j + 1] = target.charAt(j) - 48;
                sum[i][j + 1] = map[i][j + 1] + sum[i][j];
            }
        }

        for (int i = 1; i <= N; i++) {
            for (int j = K; j <= M; j++) {
                if (sum[i][j] - sum[i][j - K + 1] + map[i][j - K + 1] == 0) {
                    ans++;
                }
                ;
            }
        }

        System.out.println(ans);
    }
}
