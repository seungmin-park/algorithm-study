import java.io.*;
import java.util.*;

public class Boj_13903 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static List<int[]> cands = new ArrayList<>();
    static boolean[][] visited;
    static int[][] map, dir;
    static int R, C, N, ans = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        map = new int[R + 1][C + 1];
        for (int i = 1; i <= R; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= C; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 1 && i == 1) {
                    cands.add(new int[] { i, j });
                }
            }
        }

        N = Integer.parseInt(br.readLine());

        dir = new int[N][2];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int y = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());
            dir[i][0] = y;
            dir[i][1] = x;
        }

        bfs();

        System.out.println(ans == Integer.MAX_VALUE ? -1 : ans);
    }

    static void bfs() {
        Queue<Integer> q = new ArrayDeque<>();
        visited = new boolean[R + 1][C + 1];

        for (int[] cand : cands) {
            int y = cand[0];
            int x = cand[1];
            q.add(y);
            q.add(x);
            q.add(0);
            visited[y][x] = true;
        }

        while (!q.isEmpty()) {
            int nowY = q.poll();
            int nowX = q.poll();
            int nowDist = q.poll();
            if (nowY == R) {
                ans = Math.min(ans, nowDist);
                return;
            }

            for (int i = 0; i < N; i++) {
                int dy = nowY + dir[i][0];
                int dx = nowX + dir[i][1];
                if (dy < 1 || dy > R || dx < 1 || dx > C) {
                    continue;
                }
                if (visited[dy][dx] || map[dy][dx] == 0) {
                    continue;
                }

                visited[dy][dx] = true;
                q.add(dy);
                q.add(dx);
                q.add(nowDist + 1);
            }
        }
    }
}
