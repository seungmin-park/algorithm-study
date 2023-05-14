import java.io.*;
import java.util.*;

public class Boj_3184 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static String[] farm;
    static final char WOLF = 'v';
    static final char SHEEP = 'o';
    static final char FENCE = '#';
    static boolean[][] visited;
    static int[][] dir = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };
    static int R, C, wolfAns, sheepAns;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        farm = new String[R];
        visited = new boolean[R][C];

        for (int i = 0; i < R; i++) {
            farm[i] = br.readLine();
        }

        for (int col = 0; col < R; col++) {
            for (int row = 0; row < C; row++) {
                if (farm[col].charAt(row) == FENCE)
                    continue;
                if (visited[col][row])
                    continue;
                bfs(col, row);
            }
        }

        sb.append(sheepAns).append(" ").append(wolfAns);
        System.out.println(sb);
    }

    static void bfs(int y, int x) {
        Queue<Integer> q = new LinkedList<>();
        q.add(y);
        q.add(x);
        visited[y][x] = true;
        int wolfCnt = 0;
        int sheepCnt = 0;
        if (farm[y].charAt(x) == WOLF)
            wolfCnt++;
        if (farm[y].charAt(x) == SHEEP)
            sheepCnt++;
        while (!q.isEmpty()) {
            int nowY = q.poll();
            int nowX = q.poll();
            for (int i = 0; i < 4; i++) {
                int dy = nowY + dir[i][0];
                int dx = nowX + dir[i][1];
                if (dy < 0 || dy > R - 1 || dx < 0 || dx > C - 1)
                    continue;
                if (visited[dy][dx] || farm[dy].charAt(dx) == FENCE)
                    continue;
                if (farm[dy].charAt(dx) == WOLF)
                    wolfCnt++;
                if (farm[dy].charAt(dx) == SHEEP)
                    sheepCnt++;
                visited[dy][dx] = true;
                q.add(dy);
                q.add(dx);
            }
        }

        if (sheepCnt > wolfCnt) {
            wolfCnt = 0;
        } else {
            sheepCnt = 0;
        }

        wolfAns += wolfCnt;
        sheepAns += sheepCnt;
    }
}
