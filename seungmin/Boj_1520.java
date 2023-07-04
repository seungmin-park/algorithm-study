import java.io.*;
import java.util.*;

public class Boj_1520 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int[][] map, distance, dir = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };
    static int N, M;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N + 1][M + 1];
        distance = new int[N + 1][M + 1];

        for (int col = 1; col <= N; col++) {
            st = new StringTokenizer(br.readLine());
            for (int row = 1; row <= M; row++) {
                map[col][row] = Integer.parseInt(st.nextToken());
                distance[col][row] = -1;
            }
        }

        System.out.println(dfs(1, 1));
    }

    static int dfs(int y, int x) {
        if (y == N && x == M) {
            return 1;
        }
        if (distance[y][x] != -1) {
            return distance[y][x];
        }
        distance[y][x] = 0;
        for (int i = 0; i < 4; i++) {
            int dy = y + dir[i][0];
            int dx = x + dir[i][1];
            if (dy < 1 || dy > N || dx < 1 || dx > M) {
                continue;
            }
            if (map[dy][dx] >= map[y][x]) {
                continue;
            }
            distance[y][x] += dfs(dy, dx);
        }

        return distance[y][x];
    }
}
