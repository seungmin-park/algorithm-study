import java.io.*;
import java.util.*;

public class Boj_21938 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static boolean[][] visited;
    static int[][] map, dir = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };
    static int N, M, T, ans;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N + 1][M + 1];
        visited = new boolean[N + 1][M + 1];
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= M; j++) {
                int sum = 0;
                for (int k = 1; k <= 3; k++) {
                    sum += Integer.parseInt(st.nextToken());
                }
                map[i][j] = sum;
            }
        }

        T = Integer.parseInt(br.readLine());

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= M; j++) {
                map[i][j] = map[i][j] / 3 >= T ? 255 : 0;
            }
        }

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= M; j++) {
                if (visited[i][j] || map[i][j] != 255) {
                    continue;
                }

                bfs(i, j);
                ans++;
            }
        }

        System.out.println(ans);
    }

    static void bfs(int y, int x) {
        Queue<Integer> q = new LinkedList<>();
        q.add(y);
        q.add(x);
        visited[y][x] = true;

        while (!q.isEmpty()) {
            int nowY = q.poll();
            int nowX = q.poll();
            for (int i = 0; i < 4; i++) {
                int dy = nowY + dir[i][0];
                int dx = nowX + dir[i][1];
                if (dy < 1 || dy > N || dx < 1 || dx > M) {
                    continue;
                }
                if (visited[dy][dx] || map[dy][dx] == 0) {
                    continue;
                }

                q.add(dy);
                q.add(dx);
                visited[dy][dx] = true;
            }
        }
    }
}
