import java.io.*;
import java.util.*;

public class Boj_2458 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int[][] relationships;
    static int N, M, ans;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        relationships = new int[N + 1][N + 1];

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                relationships[i][j] = Integer.MAX_VALUE;
            }
        }

        for (int i = 1; i <= M; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            relationships[from][to] = 1;
        }

        for (int k = 1; k <= N; k++) {
            for (int a = 1; a <= N; a++) {
                for (int b = 1; b <= N; b++) {
                    if (relationships[a][k] == Integer.MAX_VALUE || relationships[k][b] == Integer.MAX_VALUE) {
                        continue;
                    }
                    relationships[a][b] = Math.min(relationships[a][b], relationships[a][k] + relationships[k][b]);
                }
            }
        }

        for (int i = 1; i <= N; i++) {
            int cnt = 0;
            for (int j = 1; j <= N; j++) {
                if (i == j) {
                    continue;
                }
                if (relationships[i][j] != Integer.MAX_VALUE) {
                    cnt++;
                } else {
                    if (relationships[j][i] != Integer.MAX_VALUE) {
                        cnt++;
                    }
                }
            }
            if (cnt == N - 1) {
                ans++;
            }
        }

        System.out.println(ans);
    }
}
