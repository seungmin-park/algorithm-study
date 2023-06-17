import java.io.*;
import java.util.*;

public class Boj_14716 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static boolean[][] visited;
    static int[][] graph,
            dir = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 }, { 1, 1 }, { 1, -1 }, { -1, 1 }, { -1, -1 } };
    static int N, M, ans;
    static final int BACKGROUND = 0;
    static final int LETTER = 1;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        visited = new boolean[N + 1][M + 1];
        graph = new int[N + 1][M + 1];

        for (int col = 1; col <= N; col++) {
            st = new StringTokenizer(br.readLine());
            for (int row = 1; row <= M; row++) {
                graph[col][row] = Integer.parseInt(st.nextToken());
            }
        }

        for (int col = 1; col <= N; col++) {
            for (int row = 1; row <= M; row++) {
                if (visited[col][row] || graph[col][row] == BACKGROUND) {
                    continue;
                }
                bfs(col, row);
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
            for (int i = 0; i < 8; i++) {
                int dy = nowY + dir[i][0];
                int dx = nowX + dir[i][1];
                if (dy < 1 || dy > N || dx < 1 || dx > M) {
                    continue;
                }
                if (visited[dy][dx] || graph[dy][dx] == BACKGROUND) {
                    continue;
                }
                q.add(dy);
                q.add(dx);
                visited[dy][dx] = true;
            }
        }
    }
}
