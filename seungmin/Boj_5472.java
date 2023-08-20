import java.io.*;
import java.util.*;

/**
 * 오답 예외케이스(출처: https://www.acmicpc.net/board/view/119639)
 * 1
 * 2 2
 * .@
 * ..
 */
public class Boj_5472 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static String[] map;
    static int[][] results, dir = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };
    static int N, M, T, ans, startY, startX;
    static final char EMPTY = '.';
    static final char WALL = '#';
    static final char TARGET = '@';
    static final char FIRE = '*';

    public static void main(String[] args) throws IOException {
        T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            st = new StringTokenizer(br.readLine());

            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());

            results = new int[M][N];

            map = new String[M];
            for (int i = 0; i < M; i++) {
                map[i] = br.readLine();
                Arrays.fill(results[i], Integer.MAX_VALUE);
            }

            bfs();
            // for (int col = 0; col < M; col++) {
            // for (int row = 0; row < N; row++) {
            // System.out.print(results[col][row] + " ");
            // }
            // System.out.println();
            // }

            // System.out.println("================");

            if (escape()) {
                sb.append(ans + 1).append("\n");
            } else {
                sb.append("IMPOSSIBLE").append("\n");
            }
        }
        // for (int col = 0; col < M; col++) {
        // for (int row = 0; row < N; row++) {
        // System.out.print(results[col][row] + " ");
        // }
        // System.out.println();
        // }

        System.out.println(sb);
    }

    static void bfs() {
        Queue<Integer> q = new LinkedList<>();
        for (int col = 0; col < M; col++) {
            for (int row = 0; row < N; row++) {
                if (map[col].charAt(row) == FIRE) {
                    q.add(col);
                    q.add(row);
                    results[col][row] = 0;
                }
                if (map[col].charAt(row) == TARGET) {
                    startY = col;
                    startX = row;
                    map[col] = map[col].substring(0, row) + '.' + map[col].substring(row + 1, N);
                }
            }
        }

        while (!q.isEmpty()) {
            int nowY = q.poll();
            int nowX = q.poll();

            for (int i = 0; i < 4; i++) {
                int dy = nowY + dir[i][0];
                int dx = nowX + dir[i][1];
                if (dy < 0 || dy >= M || dx < 0 || dx >= N) {
                    continue;
                }
                if (results[dy][dx] != Integer.MAX_VALUE || map[dy].charAt(dx) == WALL) {
                    continue;
                }
                q.add(dy);
                q.add(dx);
                results[dy][dx] = results[nowY][nowX] + 1;
            }
        }
    }

    static boolean escape() {
        Queue<Integer> q = new LinkedList<>();
        q.add(startY);
        q.add(startX);
        results[startY][startX] = 0;

        while (!q.isEmpty()) {
            int nowY = q.poll();
            int nowX = q.poll();
            // int nowCnt = q.poll();
            if (map[nowY].charAt(nowX) == EMPTY) {
                if (nowY == M - 1 || nowX == N - 1 || nowY == 0 || nowX == 0) {
                    ans = results[nowY][nowX];
                    return true;
                }
            }
            for (int i = 0; i < 4; i++) {
                int dy = nowY + dir[i][0];
                int dx = nowX + dir[i][1];
                if (dy < 0 || dy >= M || dx < 0 || dx >= N) {
                    continue;
                }
                if (results[dy][dx] <= results[nowY][nowX] + 1 || map[dy].charAt(dx) == WALL) {
                    continue;
                }

                q.add(dy);
                q.add(dx);
                results[dy][dx] = results[nowY][nowX] + 1;
            }
        }

        return false;
    }
}
