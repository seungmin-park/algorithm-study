import java.io.*;
import java.util.*;

public class Boj_25416 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int[][] map, distance, dir = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };
    static int startY, startX, endY, endX;

    public static void main(String[] args) throws IOException {
        map = new int[5][5];
        distance = new int[5][5];

        for (int col = 0; col < 5; col++) {
            st = new StringTokenizer(br.readLine());
            for (int row = 0; row < 5; row++) {
                map[col][row] = Integer.parseInt(st.nextToken());
                distance[col][row] = -1;
                if (map[col][row] == 1) {
                    endY = col;
                    endX = row;
                }
            }
        }

        st = new StringTokenizer(br.readLine());
        startY = Integer.parseInt(st.nextToken());
        startX = Integer.parseInt(st.nextToken());

        bfs();

        System.out.println(distance[endY][endX]);
    }

    static void bfs() {
        Queue<Integer> q = new LinkedList<>();
        q.add(startY);
        q.add(startX);

        distance[startY][startX] = 0;

        while (!q.isEmpty()) {
            int nowY = q.poll();
            int nowX = q.poll();
            for (int i = 0; i < 4; i++) {
                int dy = nowY + dir[i][0];
                int dx = nowX + dir[i][1];
                if (dy < 0 || dy > 4 || dx < 0 || dx > 4) {
                    continue;
                }
                if (distance[dy][dx] != -1 || map[dy][dx] == -1) {
                    continue;
                }
                distance[dy][dx] = distance[nowY][nowX] + 1;
                q.add(dy);
                q.add(dx);
            }
        }
    }
}
