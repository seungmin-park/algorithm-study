import java.io.*;
import java.util.*;

public class Boj_11123 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static String[] farm;
    static boolean[][] visited;
    static int[][] dir = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };
    static int T, N, M;

    public static void main(String[] args) throws IOException {
        T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            int ans = 0;
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            farm = new String[N];
            visited = new boolean[N][M];

            for (int col = 0; col < N; col++) {
                farm[col] = br.readLine();
            }

            for (int col = 0; col < N; col++) {
                for (int row = 0; row < M; row++) {
                    if (farm[col].charAt(row) == '.' || visited[col][row]) {
                        continue;
                    }
                    bfs(col, row);
                    ans++;
                }
            }

            sb.append(ans).append("\n");
        }
        System.out.println(sb);
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
                if (farm[dy].charAt(dx) == '.' || visited[dy][dx]) {
                    continue;
                }
                q.add(dy);
                q.add(dx);
                visited[dy][dx] = true;
            }
        }
    }
}