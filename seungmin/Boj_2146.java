import java.io.*;
import java.util.*;

public class Boj_2146 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int[][] map, dir = { { 1, 0 }, { 0, 1 }, { -1, 0 }, { 0, -1 } };
    static boolean[][] visited;
    static int N, ans = Integer.MAX_VALUE;

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

        int number = 1;
        for (int col = 1; col <= N; col++) {
            for (int row = 1; row <= N; row++) {
                if (visited[col][row] || map[col][row] == 0) {
                    continue;
                }

                giveNumber(col, row, number);
                number++;
            }
        }

        for (int col = 1; col <= N; col++) {
            for (int row = 1; row <= N; row++) {
                visited = new boolean[N + 1][N + 1];
                if (visited[col][row] || map[col][row] == 0) {
                    continue;
                }
                bfs(col, row);
            }
        }

        System.out.println(ans);
    }

    static void giveNumber(int y, int x, int number) {
        Queue<Integer> q = new LinkedList<>();
        q.add(y);
        q.add(x);
        visited[y][x] = true;
        map[y][x] = number;

        while (!q.isEmpty()) {
            int nowY = q.poll();
            int nowX = q.poll();
            for (int i = 0; i < 4; i++) {
                int dy = nowY + dir[i][0];
                int dx = nowX + dir[i][1];
                if (dy < 1 || dy > N || dx < 1 || dx > N) {
                    continue;
                }
                if (visited[dy][dx] || map[dy][dx] == 0) {
                    continue;
                }
                map[dy][dx] = number;
                visited[dy][dx] = true;
                q.add(dy);
                q.add(dx);
            }
        }
    }

    static void bfs(int y, int x) {
        int number = map[y][x];
        Queue<Integer> q = new LinkedList<>();
        q.add(y);
        q.add(x);
        q.add(0);
        visited[y][x] = true;

        while (!q.isEmpty()) {
            int nowY = q.poll();
            int nowX = q.poll();
            int cnt = q.poll();
            for (int i = 0; i < 4; i++) {
                int dy = nowY + dir[i][0];
                int dx = nowX + dir[i][1];
                if (dy < 1 || dy > N || dx < 1 || dx > N) {
                    continue;
                }
                if (visited[dy][dx] || map[dy][dx] == number) {
                    continue;
                }

                visited[dy][dx] = true;
                q.add(dy);
                q.add(dx);
                q.add(cnt + 1);
                if (map[dy][dx] != 0 && map[dy][dx] != number) {
                    ans = Math.min(ans, cnt);
                }
            }
        }
    }
}
