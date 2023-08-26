import java.io.*;
import java.util.*;

public class Boj_4179 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static String[] map;
    static int[][] dist, dir = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };
    static int R, C, startY, startX, ans;
    static final char WALL = '#';
    static final char EMPTY = '.';
    static final char TARGET = 'J';
    static final char FIRE = 'F';

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        dist = new int[R][C];
        map = new String[R];

        for (int r = 0; r < R; r++) {
            map[r] = br.readLine();
            Arrays.fill(dist[r], Integer.MAX_VALUE);
        }

        bfs();

        if (escape()) {
            System.out.println(ans + 1);
        } else {
            System.out.println("IMPOSSIBLE");
        }
    }

    static void bfs() {
        Queue<Integer> q = new LinkedList<>();
        for (int r = 0; r < R; r++) {
            for (int c = 0; c < C; c++) {
                if (map[r].charAt(c) == FIRE) {
                    q.add(r);
                    q.add(c);
                    dist[r][c] = 0;
                }
                if (map[r].charAt(c) == TARGET) {
                    startY = r;
                    startX = c;
                    map[r] = map[r].substring(0, c) + EMPTY + map[r].substring(c + 1, C);
                }
            }
        }

        while (!q.isEmpty()) {
            int nowY = q.poll();
            int nowX = q.poll();
            for (int i = 0; i < 4; i++) {
                int dy = nowY + dir[i][0];
                int dx = nowX + dir[i][1];
                if (dy < 0 || dy >= R || dx < 0 || dx >= C) {
                    continue;
                }
                if (map[dy].charAt(dx) == WALL || dist[dy][dx] != Integer.MAX_VALUE) {
                    continue;
                }

                q.add(dy);
                q.add(dx);
                dist[dy][dx] = dist[nowY][nowX] + 1;
            }
        }
    }

    static boolean escape() {
        Queue<Integer> q = new LinkedList<>();
        q.add(startY);
        q.add(startX);
        dist[startY][startX] = 0;

        while (!q.isEmpty()) {
            int nowY = q.poll();
            int nowX = q.poll();
            if (nowY == 0 || nowY == R - 1 || nowX == 0 || nowX == C - 1) {
                ans = dist[nowY][nowX];
                return true;
            }

            for (int i = 0; i < 4; i++) {
                int dy = nowY + dir[i][0];
                int dx = nowX + dir[i][1];
                if (dy < 0 || dy >= R || dx < 0 || dx >= C) {
                    continue;
                }
                if (map[dy].charAt(dx) == WALL || dist[dy][dx] <= dist[nowY][nowX] + 1) {
                    continue;
                }

                q.add(dy);
                q.add(dx);
                dist[dy][dx] = dist[nowY][nowX] + 1;
            }
        }

        return false;
    }
}
