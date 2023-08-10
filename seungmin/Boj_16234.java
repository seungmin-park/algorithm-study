import java.io.*;
import java.util.*;

public class Boj_16234 {
    static class Union {
        int people, cnt;

        Union(int people, int cnt) {
            this.people = people;
            this.cnt = cnt;
        }
    }

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static List<int[]> unions;
    static boolean[][] visited;
    static int[][] map, dir = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };
    static int N, L, R, ans;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        map = new int[N + 1][N + 1];
        visited = new boolean[N + 1][N + 1];
        for (int col = 1; col <= N; col++) {
            st = new StringTokenizer(br.readLine());
            for (int row = 1; row <= N; row++) {
                map[col][row] = Integer.parseInt(st.nextToken());
            }
        }

        boolean flag = true;
        while (flag) {
            flag = false;
            for (int col = 1; col <= N; col++) {
                for (int row = 1; row <= N; row++) {
                    if (visited[col][row]) {
                        continue;
                    }
                    unions = new ArrayList<>();
                    bfs(col, row);
                    if (unions.size() > 1) {
                        move();
                        flag = true;
                    }
                }
            }
            if (flag) {
                ans++;
            }
            init();
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
            unions.add(new int[] { nowY, nowX });

            for (int i = 0; i < 4; i++) {
                int dy = nowY + dir[i][0];
                int dx = nowX + dir[i][1];
                if (dy < 1 || dy > N || dx < 1 || dx > N) {
                    continue;
                }
                if (visited[dy][dx]) {
                    continue;
                }
                int diff = Math.abs(map[nowY][nowX] - map[dy][dx]);
                if (L <= diff && diff <= R) {
                    q.add(dy);
                    q.add(dx);
                    visited[dy][dx] = true;
                }
            }
        }
    }

    static void move() {
        int sum = 0;
        int size = unions.size();
        for (int[] union : unions) {
            sum += map[union[0]][union[1]];
        }
        int avg = sum / size;
        for (int[] union : unions) {
            map[union[0]][union[1]] = avg;
        }
    }

    static void init() {
        for (int col = 1; col <= N; col++) {
            for (int row = 1; row <= N; row++) {
                visited[col][row] = false;
            }
        }
    }
}
