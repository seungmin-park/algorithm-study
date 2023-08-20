import java.io.*;
import java.util.*;

public class Boj_2665 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static String[] map;
    static boolean[][] visited;
    static int[][] dist, dir = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };
    static int N, ans = Integer.MAX_VALUE;
    static final char WALL = '0';
    static final char EMPTY = '1';

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        map = new String[N];
        dist = new int[N][N];
        visited = new boolean[N][N];

        for (int col = 0; col < N; col++) {
            map[col] = br.readLine();
            Arrays.fill(dist[col], Integer.MAX_VALUE);
        }

        bfs();

        System.out.println(dist[N - 1][N - 1]);
    }

    static void bfs() {
        Queue<Integer> q = new LinkedList<>();
        q.add(0);
        q.add(0);
        dist[0][0] = (map[0].charAt(0) == EMPTY) ? 0 : 1;
        q.add(dist[0][0]);

        while (!q.isEmpty()) {
            int nowY = q.poll();
            int nowX = q.poll();
            int nowDist = q.poll();
            if (nowDist > dist[nowY][nowX]) {
                continue;
            }
            for (int i = 0; i < 4; i++) {
                int dy = nowY + dir[i][0];
                int dx = nowX + dir[i][1];
                if (dy < 0 || dy >= N || dx < 0 || dx >= N) {
                    continue;
                }
                if (map[dy].charAt(dx) == WALL) {
                    if (dist[dy][dx] <= dist[nowY][nowX] + 1) {
                        continue;
                    }
                    dist[dy][dx] = dist[nowY][nowX] + 1;
                    q.add(dy);
                    q.add(dx);
                    q.add(dist[dy][dx]);
                } else {
                    if (dist[dy][dx] <= dist[nowY][nowX]) {
                        continue;
                    }
                    dist[dy][dx] = dist[nowY][nowX];
                    q.add(dy);
                    q.add(dx);
                    q.add(dist[dy][dx]);
                }
            }
        }
    }
}
