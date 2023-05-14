import java.io.*;
import java.util.*;

public class Boj_17086 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int[][] graph, distance;
    static int[][] dir = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 }, { 1, 1 }, { 1, -1 }, { -1, 1 }, { -1, -1 } };
    static int N, M, ans = Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        graph = new int[N + 1][M + 1];
        distance = new int[N + 1][M + 1];

        for (int col = 1; col <= N; col++) {
            st = new StringTokenizer(br.readLine());
            for (int row = 1; row <= M; row++) {
                graph[col][row] = Integer.parseInt(st.nextToken());
                distance[col][row] = -1;
            }
        }

        bfs();

        for (int col = 1; col <= N; col++) {
            for (int row = 1; row <= M; row++) {
                ans = Math.max(distance[col][row], ans);
            }
        }

        System.out.println(ans);
    }

    static void bfs() {
        Queue<Integer> q = new LinkedList<>();
        for (int col = 1; col <= N; col++) {
            for (int row = 1; row <= M; row++) {
                if (graph[col][row] == 1) {
                    q.add(col);
                    q.add(row);
                    distance[col][row] = 0;
                }
            }
        }

        while (!q.isEmpty()) {
            int nowY = q.poll();
            int nowX = q.poll();
            for (int i = 0; i < 8; i++) {
                int dy = nowY + dir[i][0];
                int dx = nowX + dir[i][1];
                if (dy < 1 || dy > N || dx < 1 || dx > M)
                    continue;
                if (distance[dy][dx] == -1) {
                    distance[dy][dx] = distance[nowY][nowX] + 1;
                    q.add(dy);
                    q.add(dx);
                }
            }
        }
    }
}
