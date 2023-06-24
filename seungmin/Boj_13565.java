import java.io.*;
import java.util.*;

public class Boj_13565 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static boolean[][] visited;
    static int[][] lab, dir = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };
    static int N, M;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        lab = new int[N + 1][M + 1];
        visited = new boolean[N + 1][M + 1];

        for (int col = 1; col <= N; col++) {
            String next = br.readLine();
            for (int row = 1; row <= M; row++) {
                lab[col][row] = next.charAt(row - 1) - 48;
            }
        }

        for (int row = 1; row <= M; row++) {
            if (visited[1][row] || lab[1][row] == 1) {
                continue;
            }
            bfs(1, row);
        }

        for (int row = 1; row <= M; row++) {
            if (visited[N][row]) {
                System.out.println("YES");
                return;
            }
        }
        System.out.println("NO");
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
                if (visited[dy][dx] || lab[dy][dx] == 1) {
                    continue;
                }

                q.add(dy);
                q.add(dx);
                visited[dy][dx] = true;
            }
        }
    }
}
