import java.io.*;
import java.util.*;

public class Boj14923 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int[][] map, dir = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };
    static int[][][] dist;
    static int N, M, Hx, Hy, Ex, Ey;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        Hy = Integer.parseInt(st.nextToken());
        Hx = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        Ey = Integer.parseInt(st.nextToken());
        Ex = Integer.parseInt(st.nextToken());

        map = new int[N + 1][M + 1];
        dist = new int[2][N + 1][M + 1];

        for (int y = 1; y <= N; y++) {
            st = new StringTokenizer(br.readLine());
            for (int x = 1; x <= M; x++) {
                map[y][x] = Integer.parseInt(st.nextToken());
                dist[0][y][x] = -1;
                dist[1][y][x] = -1;
            }
        }

        bfs();
        System.out.println((dist[1][Ey][Ex] == dist[0][Ey][Ex] && dist[0][Ey][Ex] == -1) ? -1
                : Math.min(dist[1][Ey][Ex], dist[0][Ey][Ex]));
    }

    static void bfs() {
        Queue<Integer> q = new LinkedList<>();
        q.add(Hy);
        q.add(Hx);
        q.add(0);
        dist[0][Hy][Hx] = 0;

        while (!q.isEmpty()) {
            int nowY = q.poll();
            int nowX = q.poll();
            int nowState = q.poll();
            for (int i = 0; i < 4; i++) {
                int dy = nowY + dir[i][0];
                int dx = nowX + dir[i][1];
                if (dy < 1 || dy > N || dx < 1 || dx > M) {
                    continue;
                }
                if (dist[nowState][dy][dx] != -1) {
                    continue;
                }
                if (nowState == 1) {
                    if (map[dy][dx] == 1) {
                        continue;
                    }
                    q.add(dy);
                    q.add(dx);
                    q.add(nowState);
                    dist[nowState][dy][dx] = dist[nowState][nowY][nowX] + 1;
                } else {
                    if (map[dy][dx] == 1) {
                        q.add(dy);
                        q.add(dx);
                        q.add(1);
                        dist[1][dy][dx] = dist[nowState][nowY][nowX] + 1;
                    } else {
                        q.add(dy);
                        q.add(dx);
                        q.add(nowState);
                        dist[nowState][dy][dx] = dist[nowState][nowY][nowX] + 1;
                    }
                }
            }
        }
    }
}
