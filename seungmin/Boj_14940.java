import java.io.*;
import java.util.*;

public class Boj_14940 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static int[][] graph, dist, dir = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };
    static int N, M, startX, startY;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        graph = new int[N + 1][M + 1];
        dist = new int[N + 1][M + 1];

        for (int col = 1; col <= N; col++) {
            st = new StringTokenizer(br.readLine());
            for (int row = 1; row <= M; row++) {
                int curr = Integer.parseInt(st.nextToken());
                if (curr == 2) {
                    startY = col;
                    startX = row;
                }
                graph[col][row] = curr;
                dist[col][row] = -1;
            }
        }

        bfs();

        for (int col = 1; col <= N; col++) {
            for (int row = 1; row <= M; row++) {
                sb.append(graph[col][row] == 0 ? 0 : dist[col][row]).append(" ");
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }

    static void bfs() {
        Queue<Integer> q = new LinkedList<>();
        q.add(startY);
        q.add(startX);
        dist[startY][startX] = 0;

        while (!q.isEmpty()) {
            int nowY = q.poll();
            int nowX = q.poll();
            for (int i = 0; i < 4; i++) {
                int dy = nowY + dir[i][0];
                int dx = nowX + dir[i][1];
                if (dy < 1 || dy > N || dx < 1 || dx > M)
                    continue;
                if (graph[dy][dx] == 0 || dist[dy][dx] != -1)
                    continue;
                dist[dy][dx] = dist[nowY][nowX] + 1;
                q.add(dy);
                q.add(dx);
            }
        }
    }
}
