import java.io.*;
import java.util.*;

public class Boj_4993 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static String[] graph;
    static boolean[][] visited;
    static int[][] dir = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    static int N, M, startY, startX;

    public static void main(String[] args) throws IOException {
        while (true) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            if (N == 0 && M == 0) {
                break;
            }

            visited = new boolean[M][N];
            graph = new String[M];

            for (int i = 0; i < M; i++) {
                graph[i] = br.readLine();
                for (int j = 0; j < N; j++) {
                    if (graph[i].charAt(j) == '@') {
                        startY = i;
                        startX = j;
                    }
                }
            }

            sb.append(bfs(startY, startX)).append("\n");
        }

        System.out.println(sb);
    }

    static int bfs(int y, int x) {
        Queue<Integer> q = new LinkedList<>();
        q.add(y);
        q.add(x);
        visited[y][x] = true;
        int step = 1;

        while (!q.isEmpty()) {
            int nowY = q.poll();
            int nowX = q.poll();
            for (int i = 0; i < 4; i++) {
                int dy = nowY + dir[i][0];
                int dx = nowX + dir[i][1];
                if (dy < 0 || dy >= M || dx < 0 || dx >= N) {
                    continue;
                }
                if (visited[dy][dx] || graph[dy].charAt(dx) == '#') {
                    continue;
                }

                q.add(dy);
                q.add(dx);
                visited[dy][dx] = true;
                step++;
            }
        }

        return step;
    }
}