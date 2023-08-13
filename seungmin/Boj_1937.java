import java.io.*;
import java.util.*;

public class Boj_1937 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int[][] map, dist, dir = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };
    static int N, ans;

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());

        map = new int[N + 1][N + 1];
        dist = new int[N + 1][N + 1];
        for (int col = 1; col <= N; col++) {
            st = new StringTokenizer(br.readLine());
            for (int row = 1; row <= N; row++) {
                map[col][row] = Integer.parseInt(st.nextToken());
                dist[col][row] = -1;
            }
        }

        func();

        System.out.println(ans);
    }

    static void func() {
        for (int col = 1; col <= N; col++) {
            for (int row = 1; row <= N; row++) {
                if (dist[col][row] != -1) {
                    continue;
                }
                ans = Math.max(ans, dfs(col, row));
            }
        }
    }

    static int dfs(int y, int x) {
        dist[y][x] = 1;

        for (int i = 0; i < 4; i++) {
            int dy = y + dir[i][0];
            int dx = x + dir[i][1];
            if (dy < 1 || dy > N || dx < 1 || dx > N) {
                continue;
            }
            if (map[dy][dx] <= map[y][x]) {
                continue;
            }
            if (dist[dy][dx] != -1) {
                dist[y][x] = Math.max(dist[y][x], dist[dy][dx] + 1);
                continue;
            }
            dist[y][x] = Math.max(dist[y][x], dfs(dy, dx) + 1);
        }

        return dist[y][x];
    }
}
