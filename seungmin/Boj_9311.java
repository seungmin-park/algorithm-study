import java.io.*;
import java.util.*;

public class Boj_9311 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static String[] graph;
    static int[][] visited, dir = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };
    static int T, N, M, startY, startX;

    public static void main(String[] args) throws IOException {
        T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());

            graph = new String[N];
            visited = new int[N][M];
            for (int i = 0; i < N; i++) {
                graph[i] = br.readLine();
                for (int j = 0; j < M; j++) {
                    visited[i][j] = -1;
                    if (graph[i].charAt(j) == 'S') {
                        startY = i;
                        startX = j;
                    }
                }
            }

            int ans = bfs();

            if (ans == -1) {
                sb.append("No Exit");
            } else {
                sb.append("Shortest Path: ").append(ans);
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }

    static int bfs() {
        Queue<Integer> q = new LinkedList<>();
        q.add(startY);
        q.add(startX);
        visited[startY][startX] = 0;

        while (!q.isEmpty()) {
            int nowY = q.poll();
            int nowX = q.poll();
            if (graph[nowY].charAt(nowX) == 'G') {
                return visited[nowY][nowX];
            }
            for (int i = 0; i < 4; i++) {
                int dy = nowY + dir[i][0];
                int dx = nowX + dir[i][1];
                if (dy < 0 || dy >= N || dx < 0 || dx >= M) {
                    continue;
                }
                if (graph[dy].charAt(dx) == 'X' || visited[dy][dx] != -1) {
                    continue;
                }

                q.add(dy);
                q.add(dx);
                visited[dy][dx] = visited[nowY][nowX] + 1;
            }
        }
        return -1;
    }
}
