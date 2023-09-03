import java.io.*;
import java.util.*;

public class Boj_17836 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int[][] map, dist, dir = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };
    static int N, M, startY, startX, T, ans = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        T = Integer.parseInt(st.nextToken());

        map = new int[N + 1][M + 1];
        dist = new int[N + 1][M + 1];
        for (int y = 1; y <= N; y++) {
            st = new StringTokenizer(br.readLine());
            for (int x = 1; x <= M; x++) {
                map[y][x] = Integer.parseInt(st.nextToken());
                dist[y][x] = Integer.MAX_VALUE;
                if (map[y][x] == 2) {
                    startY = y;
                    startX = x;
                }
            }
        }

        bfs();
        // 1. 둘 다 접근 불가능
        if (dist[N][M] == Integer.MAX_VALUE && dist[startY][startX] == Integer.MAX_VALUE) {
            System.out.println("Fail");
            return;
        }
        // 2. 다이렉트만 가능
        if (dist[startY][startX] == Integer.MAX_VALUE) {
            if (dist[N][M] > T) {
                System.out.println("Fail");
            } else {
                System.out.println(dist[N][M]);
            }
            return;
        }
        // 3. 검으로만 가능
        if (dist[N][M] == Integer.MAX_VALUE) {
            if (dist[startY][startX] + (Math.abs(N - startY) + Math.abs(M - startX)) > T) {
                System.out.println("Fail");
            } else {
                System.out.println(dist[startY][startX] + (Math.abs(N - startY) + Math.abs(M - startX)));
            }
            return;
        }
        // 4. 둘 다 가능
        ans = Math.min(dist[N][M], dist[startY][startX] + (Math.abs(N - startY) + Math.abs(M - startX)));

        if (ans > T) {
            System.out.println("Fail");
        } else {
            System.out.println(ans);
        }
    }

    static void bfs() {
        Queue<Integer> q = new LinkedList<>();
        q.add(1);
        q.add(1);
        dist[1][1] = 0;

        while (!q.isEmpty()) {
            int nowY = q.poll();
            int nowX = q.poll();
            for (int i = 0; i < 4; i++) {
                int dy = nowY + dir[i][0];
                int dx = nowX + dir[i][1];
                if (dy < 1 || dy > N || dx < 1 || dx > M) {
                    continue;
                }
                if (dist[dy][dx] != Integer.MAX_VALUE || map[dy][dx] == 1) {
                    continue;
                }

                q.add(dy);
                q.add(dx);
                dist[dy][dx] = dist[nowY][nowX] + 1;
            }
        }
    }
}
