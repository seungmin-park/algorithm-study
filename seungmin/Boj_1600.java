import java.io.*;
import java.util.*;

public class Boj_1600 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int[][] map,
            dirH = { { 1, -2 }, { 2, -1 }, { 1, 2 }, { 2, 1 }, { -1, -2 }, { -2, -1 }, { -1, 2 }, { -2, 1 } },
            dirM = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };
    static int[][][] distance;
    static int K, W, H, ans = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        K = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        W = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());
        map = new int[H + 1][W + 1];
        distance = new int[K + 1][H + 1][W + 1];

        for (int col = 1; col <= H; col++) {
            st = new StringTokenizer(br.readLine());
            for (int row = 1; row <= W; row++) {
                map[col][row] = Integer.parseInt(st.nextToken());
            }
        }
        for (int k = 0; k <= K; k++) {
            for (int col = 1; col <= H; col++) {
                for (int row = 1; row <= W; row++) {
                    distance[k][col][row] = Integer.MAX_VALUE;
                }
            }
        }

        bfs();
        for (int k = 0; k <= K; k++) {
            ans = Math.min(ans, distance[k][H][W]);
        }

        System.out.print(ans == Integer.MAX_VALUE ? -1 : ans);
    }

    static void bfs() {
        Queue<Integer> q = new LinkedList<>();
        q.add(1);
        q.add(1);
        q.add(0);
        distance[0][1][1] = 0;
        while (!q.isEmpty()) {
            int nowY = q.poll();
            int nowX = q.poll();
            int nowCnt = q.poll();
            if (nowCnt < K) {
                for (int i = 0; i < 8; i++) {
                    int dy = nowY + dirH[i][0];
                    int dx = nowX + dirH[i][1];
                    if (dy < 1 || dy > H || dx < 1 || dx > W) {
                        continue;
                    }
                    if (map[dy][dx] == 1) {
                        continue;
                    }
                    if (distance[nowCnt + 1][dy][dx] > distance[nowCnt][nowY][nowX] + 1) {
                        distance[nowCnt + 1][dy][dx] = distance[nowCnt][nowY][nowX] + 1;
                        q.add(dy);
                        q.add(dx);
                        q.add(nowCnt + 1);
                    }
                }
            }
            for (int i = 0; i < 4; i++) {
                int dy = nowY + dirM[i][0];
                int dx = nowX + dirM[i][1];
                if (dy < 1 || dy > H || dx < 1 || dx > W) {
                    continue;
                }
                if (map[dy][dx] == 1) {
                    continue;
                }
                if (distance[nowCnt][dy][dx] > distance[nowCnt][nowY][nowX] + 1) {
                    distance[nowCnt][dy][dx] = distance[nowCnt][nowY][nowX] + 1;
                    q.add(dy);
                    q.add(dx);
                    q.add(nowCnt);
                }
            }

        }
    }
}
