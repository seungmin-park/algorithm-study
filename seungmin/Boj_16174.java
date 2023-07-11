import java.io.*;
import java.util.*;

public class Boj_16174 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int[][] map, distance;
    static int N;

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        map = new int[N + 1][N + 1];
        distance = new int[N + 1][N + 1];

        for (int col = 1; col <= N; col++) {
            st = new StringTokenizer(br.readLine());
            for (int row = 1; row <= N; row++) {
                map[col][row] = Integer.parseInt(st.nextToken());
                distance[col][row] = -1;
            }
        }

        bfs();
        System.out.println(distance[N][N] == -1 ? "Hing" : "HaruHaru");
    }

    static void bfs() {
        Queue<Integer> q = new LinkedList<>();
        q.add(1);
        q.add(1);
        distance[1][1] = 0;

        while (!q.isEmpty()) {
            int nowY = q.poll();
            int nowX = q.poll();
            int[][] dir = { { map[nowY][nowX], 0 }, { 0, map[nowY][nowX] } };
            for (int i = 0; i < 2; i++) {
                int dy = nowY + dir[i][0];
                int dx = nowX + dir[i][1];
                if (dy < 1 || dy > N || dx < 1 || dx > N) {
                    continue;
                }
                if (distance[dy][dx] != -1) {
                    continue;
                }
                distance[dy][dx] = distance[nowY][nowX] + 1;
                q.add(dy);
                q.add(dx);
            }
        }
    }
}
