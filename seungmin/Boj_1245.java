import java.io.*;
import java.util.*;

public class Boj_1245 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static boolean[][] visited;
    static int[][] mount,
            dir = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 }, { 1, 1 }, { 1, -1 }, { -1, 1 }, { -1, -1 } };
    static int N, M, ans, min = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        mount = new int[N + 1][M + 1];
        visited = new boolean[N + 1][M + 1];

        for (int col = 1; col <= N; col++) {
            st = new StringTokenizer(br.readLine());
            for (int row = 1; row <= M; row++) {
                mount[col][row] = Integer.parseInt(st.nextToken());
                min = Math.min(min, mount[col][row]);
            }
        }

        for (int col = 1; col <= N; col++) {
            for (int row = 1; row <= M; row++) {
                if (visited[col][row]) {
                    continue;
                }
                bfs(col, row);
            }
        }

        System.out.println(ans);
    }

    static void bfs(int y, int x) {
        Queue<Integer> q = new LinkedList<>();
        q.add(y);
        q.add(x);
        int now = mount[y][x];
        visited[y][x] = true;
        boolean isTop = true;

        while (!q.isEmpty()) {
            int nowY = q.poll();
            int nowX = q.poll();
            for (int i = 0; i < 8; i++) {
                int dy = nowY + dir[i][0];
                int dx = nowX + dir[i][1];
                if (dy < 1 || dy > N || dx < 1 || dx > M) {
                    continue;
                }
                if (now < mount[dy][dx]) {
                    isTop = false;
                } else if (!visited[dy][dx] && mount[dy][dx] == now) {
                    q.add(dy);
                    q.add(dx);
                    visited[dy][dx] = true;
                }
            }
        }

        if (isTop && now > min) {
            ans++;
        }
    }
}
