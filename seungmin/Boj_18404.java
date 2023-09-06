import java.io.*;
import java.util.*;

public class Boj_18404 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static int[][] dist;
    static int[][] map,
            dir = { { 1, -2 }, { 2, -1 }, { 2, 1 }, { 1, 2 }, { -1, 2 }, { -2, 1 }, { -2, -1 }, { -1, -2 } };
    static int N, M, startX, startY;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N + 1][N + 1];
        dist = new int[N + 1][N + 1];
        for (int i = 1; i <= N; i++) {
            Arrays.fill(dist[i], Integer.MAX_VALUE);
        }

        st = new StringTokenizer(br.readLine());
        startY = Integer.parseInt(st.nextToken());
        startX = Integer.parseInt(st.nextToken());

        bfs();

        for (int i = 1; i <= M; i++) {
            st = new StringTokenizer(br.readLine());
            int y = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());
            sb.append(dist[y][x]).append(" ");
        }

        System.out.println(sb);
    }

    static void bfs() {
        Queue<Integer> q = new LinkedList<>();
        q.add(startY);
        q.add(startX);
        dist[startY][startX] = 0;

        while (!q.isEmpty()) {
            int nowY = q.poll();
            int nowX = q.poll();
            for (int i = 0; i < 8; i++) {
                int dy = nowY + dir[i][0];
                int dx = nowX + dir[i][1];
                if (dy < 1 || dy > N || dx < 1 || dx > N) {
                    continue;
                }
                if (dist[dy][dx] != Integer.MAX_VALUE) {
                    continue;
                }

                q.add(dy);
                q.add(dx);
                dist[dy][dx] = dist[nowY][nowX] + 1;
            }
        }
    }
}
