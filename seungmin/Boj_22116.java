import java.io.*;
import java.util.*;

public class Boj_22116 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static boolean[][] visited;
    static int[][] map, dir = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };
    static int N, ans = Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        map = new int[N + 1][N + 1];
        visited = new boolean[N + 1][N + 1];

        for (int col = 1; col <= N; col++) {
            st = new StringTokenizer(br.readLine());
            for (int row = 1; row <= N; row++) {
                map[col][row] = Integer.parseInt(st.nextToken());
            }
        }

        bfs(1, 1);

        System.out.println(ans);
    }

    static void bfs(int y, int x) {
        PriorityQueue<int[]> q = new PriorityQueue<>((a1, a2) -> a1[2] - a2[2]);
        q.add(new int[] { y, x, 0 });

        while (!q.isEmpty()) {
            int[] now = q.poll();
            int nowY = now[0];
            int nowX = now[1];
            visited[nowY][nowX] = true;
            ans = Math.max(ans, now[2]);
            if (nowY == N && nowX == N) {
                return;
            }
            for (int i = 0; i < 4; i++) {
                int dy = nowY + dir[i][0];
                int dx = nowX + dir[i][1];
                if (dy < 1 || dy > N || dx < 1 || dx > N) {
                    continue;
                }
                if (visited[dy][dx]) {
                    continue;
                }
                q.add(new int[] { dy, dx, Math.abs(map[dy][dx] - map[nowY][nowX]) });
            }
        }
    }
}
