import java.io.*;
import java.util.*;

public class Boj_6186 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static String[] graph;
    static boolean[][] visited;
    static int[][] dir = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    static int N, M, ans;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        graph = new String[N];
        visited = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            graph[i] = br.readLine();
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (graph[i].charAt(j) == '.' || visited[i][j]) {
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
                if (dy < 0 || dy >= N || dx < 0 || dx >= M) {
                    continue;
                }
                if (graph[dy].charAt(dx) == '.' || visited[dy][dx]) {
                    continue;
                }

                q.add(dy);
                q.add(dx);
                visited[dy][dx] = true;
            }
        }
    }
}
