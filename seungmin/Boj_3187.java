import java.io.*;
import java.util.*;

public class Boj_3187 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static String[] farms;
    static boolean[][] visited;
    static int[][] dir = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };
    static int R, C, wolfCnt, sheepCnt;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        farms = new String[R + 1];
        visited = new boolean[R + 1][C];

        for (int i = 1; i <= R; i++) {
            farms[i] = br.readLine();
        }

        for (int col = 1; col <= R; col++) {
            for (int row = 0; row < C; row++) {
                if (visited[col][row] || farms[col].charAt(row) == '#') {
                    continue;
                }
                bfs(col, row);
            }
        }

        System.out.println(sb.append(sheepCnt).append(" ").append(wolfCnt));
    }

    static void bfs(int y, int x) {
        Queue<Integer> q = new LinkedList<>();
        q.add(y);
        q.add(x);
        visited[y][x] = true;
        int wolf = 0;
        int sheep = 0;
        while (!q.isEmpty()) {
            int nowY = q.poll();
            int nowX = q.poll();
            if (farms[nowY].charAt(nowX) == 'v') {
                wolf++;
            }
            if (farms[nowY].charAt(nowX) == 'k') {
                sheep++;
            }
            for (int i = 0; i < 4; i++) {
                int dy = nowY + dir[i][0];
                int dx = nowX + dir[i][1];
                if (dy < 1 || dy > R || dx < 0 || dx > C - 1) {
                    continue;
                }
                if (visited[dy][dx] || farms[dy].charAt(dx) == '#') {
                    continue;
                }
                q.add(dy);
                q.add(dx);
                visited[dy][dx] = true;
            }
        }
        if (sheep > wolf) {
            sheepCnt += sheep;
        } else {
            wolfCnt += wolf;
        }
    }
}
