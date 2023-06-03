import java.io.*;
import java.util.*;

public class Boj_18243 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static List<Integer>[] network;
    static int[][] dist;
    static int N, K;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        dist = new int[N + 1][N + 1];
        for (int col = 1; col <= N; col++) {
            for (int row = 1; row <= N; row++) {
                dist[col][row] = Integer.MAX_VALUE;
            }
        }

        for (int i = 1; i <= K; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            dist[a][b] = 1;
            dist[b][a] = 1;
        }

        for (int k = 1; k <= N; k++) {
            for (int a = 1; a <= N; a++) {
                for (int b = 1; b <= N; b++) {
                    if (dist[a][k] == Integer.MAX_VALUE || dist[k][b] == Integer.MAX_VALUE) {
                        continue;
                    }
                    dist[a][b] = Math.min(dist[a][b], dist[a][k] + dist[k][b]);
                }
            }
        }

        for (int col = 1; col <= N; col++) {
            for (int row = 1; row <= N; row++) {
                if (dist[col][row] > 6) {
                    System.out.println("Big World!");
                    return;
                }
            }
        }

        System.out.println("Small World!");
    }
}
