import java.io.*;
import java.util.*;

public class Boj_2573 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static List<int[]> temp;
    static boolean[][] visited;
    static boolean isDivided, isSearched = true;
    static int[][] map, dir = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };
    static int N, M, ans;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N + 1][M + 1];
        visited = new boolean[N + 1][M + 1];

        for (int col = 1; col <= N; col++) {
            st = new StringTokenizer(br.readLine());
            for (int row = 1; row <= M; row++) {
                map[col][row] = Integer.parseInt(st.nextToken());
            }
        }

        while (isSearched) {
            isSearched = false;
            int cnt = 0;
            temp = new ArrayList<>();
            for (int col = 1; col <= N; col++) {
                for (int row = 1; row <= M; row++) {
                    visited[col][row] = false;
                }
            }
            for (int col = 1; col <= N; col++) {
                for (int row = 1; row <= M; row++) {
                    if (visited[col][row] || map[col][row] == 0) {
                        continue;
                    }
                    isSearched = true;
                    bfs(col, row);
                    cnt++;
                }
            }
            if (cnt > 1) {
                isDivided = true;
                break;
            }
            for (int[] t : temp) {
                map[t[0]][t[1]] = map[t[0]][t[1]] - t[2] <= 0 ? 0 : map[t[0]][t[1]] - t[2];
            }
            ans++;
        }
        System.out.println(isDivided ? ans : 0);
    }

    static void bfs(int y, int x) {
        Queue<Integer> q = new LinkedList<>();
        q.add(y);
        q.add(x);
        visited[y][x] = true;

        while (!q.isEmpty()) {
            int nowY = q.poll();
            int nowX = q.poll();
            int cnt = 0;
            for (int i = 0; i < 4; i++) {
                int dy = nowY + dir[i][0];
                int dx = nowX + dir[i][1];
                if (dy < 1 || dy > N || dx < 1 || dx > M) {
                    continue;
                }
                if (visited[dy][dx]) {
                    continue;
                }
                if (map[dy][dx] == 0) {
                    cnt++;
                    continue;
                }
                q.add(dy);
                q.add(dx);
                visited[dy][dx] = true;
            }
            if (cnt > 0) {
                temp.add(new int[] { nowY, nowX, cnt });
            }
        }
    }
}
