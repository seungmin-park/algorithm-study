import java.io.*;
import java.util.*;

public class Boj_14442 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static String[] map;
    static int[][][] dist;
    static int[][] dir = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };
    static int N, M, K;
    static final char WALL = '1';
    static final char EMPTY = '0';

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        map = new String[N];
        dist = new int[K + 1][N][M];
        for (int i = 0; i < N; i++) {
            map[i] = br.readLine();
        }

        for (int k = 0; k <= K; k++) {
            for (int n = 0; n < N; n++) {
                for (int m = 0; m < M; m++) {
                    dist[k][n][m] = -1;
                }
            }
        }

        bfs();

        int ans = Integer.MAX_VALUE;
        for (int k = 0; k <= K; k++) {
            if (dist[k][N - 1][M - 1] == -1) {
                continue;
            }
            ans = Math.min(ans, dist[k][N - 1][M - 1]);
        }

        System.out.println(ans == Integer.MAX_VALUE ? -1 : ans);
    }

    static void bfs() {
        Queue<Integer> q = new LinkedList<>();
        q.add(0);
        q.add(0);
        q.add(0);
        dist[0][0][0] = 1;

        while (!q.isEmpty()) {
            int nowK = q.poll();
            int nowY = q.poll();
            int nowX = q.poll();
            for (int i = 0; i < 4; i++) {
                int dy = nowY + dir[i][0];
                int dx = nowX + dir[i][1];
                if (dy < 0 || dy >= N || dx < 0 || dx >= M) {
                    continue;
                }
                // 벽이 아닐 경우
                if (map[dy].charAt(dx) == EMPTY) {
                    if (dist[nowK][dy][dx] != -1) {
                        continue;
                    }
                    q.add(nowK);
                    q.add(dy);
                    q.add(dx);
                    dist[nowK][dy][dx] = dist[nowK][nowY][nowX] + 1;
                } else {
                    // 벽일 경우
                    if (nowK == K) {
                        continue;
                    }
                    if (dist[nowK + 1][dy][dx] != -1) {
                        continue;
                    }
                    q.add(nowK + 1);
                    q.add(dy);
                    q.add(dx);
                    dist[nowK + 1][dy][dx] = dist[nowK][nowY][nowX] + 1;
                }
            }
        }
    }
}
