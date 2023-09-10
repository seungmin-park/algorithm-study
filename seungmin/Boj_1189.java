import java.io.*;
import java.util.*;

public class Boj_1189 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static String[] map;
    static boolean[][] visited;
    static int[][] dir = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };
    static int R, C, K, ans;
    static final char BLOCK = 'T';

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        map = new String[R];
        visited = new boolean[R][C];
        for (int i = 0; i < R; i++) {
            map[i] = br.readLine();
        }

        visited[R - 1][0] = true;
        dfs(R - 1, 0, 1);
        System.out.println(ans);
    }

    static void dfs(int y, int x, int cnt) {
        if (y == 0 && x == C - 1) {
            if (cnt == K) {
                ans++;
            }
            return;
        }
        for (int i = 0; i < 4; i++) {
            int dy = y + dir[i][0];
            int dx = x + dir[i][1];
            if (dy < 0 || dy >= R || dx < 0 || dx >= C) {
                continue;
            }
            if (visited[dy][dx] || map[dy].charAt(dx) == BLOCK) {
                continue;
            }
            visited[dy][dx] = true;

            dfs(dy, dx, cnt + 1);
            visited[dy][dx] = false;
        }
    }
}
