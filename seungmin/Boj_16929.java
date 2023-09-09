import java.io.*;
import java.util.*;

public class Boj_16929 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static String[] map;
    static boolean[][] visited;
    static int[][] dir = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };
    static boolean ans;
    static int N, M;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new String[N];

        for (int i = 0; i < N; i++) {
            map[i] = br.readLine();
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                visited = new boolean[N][M];
                dfs(i, j, map[i].charAt(j), 1, 0, 0);
                if (ans) {
                    System.out.println("Yes");
                    return;
                }
            }
        }

        System.out.println("No");
    }

    static void dfs(int y, int x, char target, int dist, int preY, int preX) {
        visited[y][x] = true;

        for (int i = 0; i < 4; i++) {
            int dy = y + dir[i][0];
            int dx = x + dir[i][1];
            if (dy < 0 || dy >= N || dx < 0 || dx >= M) {
                continue;
            }
            if (map[dy].charAt(dx) != target) {
                continue;
            }
            if (visited[dy][dx]) {
                if (dy != preY && dx != preX) {
                    if (dist > 3) {
                        ans = true;
                        return;
                    }
                }
                continue;
            }

            dfs(dy, dx, target, dist + 1, y, x);
        }
    }
}
