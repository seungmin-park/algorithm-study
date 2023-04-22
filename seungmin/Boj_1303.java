import java.io.*;
import java.util.*;

public class Boj_1303 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static String[] graph;
    static boolean[][] visited;
    static int[][] dir = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };
    static int N, M, we, your;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        graph = new String[M + 1];
        visited = new boolean[M + 1][N];
        for (int i = 1; i <= M; i++) {
            graph[i] = br.readLine();
        }

        for (int col = 1; col <= M; col++) {
            for (int row = 0; row < N; row++) {
                if (visited[col][row])
                    continue;
                char target = graph[col].charAt(row);
                int result = bfs(col, row, target);
                if (target == 'W') {
                    we += result;
                } else {
                    your += result;
                }
            }
        }

        sb.append(we).append(" ").append(your);
        System.out.println(sb);
    }

    static int bfs(int y, int x, char target) {
        int cnt = 1;
        Queue<Integer> q = new LinkedList<>();
        q.add(y);
        q.add(x);
        visited[y][x] = true;
        while (!q.isEmpty()) {
            int nowY = q.poll();
            int nowX = q.poll();
            for (int i = 0; i < 4; i++) {
                int dy = nowY + dir[i][0];
                int dx = nowX + dir[i][1];
                if (dy < 1 || dy > M || dx < 0 || dx > N - 1)
                    continue;
                if (visited[dy][dx] || graph[dy].charAt(dx) != target)
                    continue;
                cnt++;
                visited[dy][dx] = true;
                q.add(dy);
                q.add(dx);
            }
        }

        return (int) Math.pow(cnt, 2);
    }
}
