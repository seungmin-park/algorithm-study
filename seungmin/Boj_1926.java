import java.io.*;
import java.util.*;

public class Boj_1926 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static List<Integer> ans = new ArrayList<>();
    static boolean[][] visit;
    static int[][] dir = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };
    static int[][] graph;
    static int N, M;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        graph = new int[N + 1][M + 1];
        visit = new boolean[N + 1][M + 1];

        for (int col = 1; col <= N; col++) {
            st = new StringTokenizer(br.readLine());
            for (int row = 1; row <= M; row++) {
                graph[col][row] = Integer.parseInt(st.nextToken());
            }
        }

        for (int col = 1; col <= N; col++) {
            for (int row = 1; row <= M; row++) {
                if (visit[col][row] || graph[col][row] == 0)
                    continue;
                ans.add(bfs(col, row));
            }
        }
        if (ans.size() == 0) {
            sb.append(0).append("\n").append(0);
        } else
            sb.append(ans.size()).append("\n").append(Collections.max(ans));
        System.out.println(sb);
    }

    static int bfs(int startY, int startX) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[] { startY, startX });
        visit[startY][startX] = true;
        int area = 1;
        while (!q.isEmpty()) {
            int[] now = q.poll();
            int nowY = now[0];
            int nowX = now[1];
            for (int i = 0; i < 4; i++) {
                int dy = nowY + dir[i][0];
                int dx = nowX + dir[i][1];
                if (dy < 1 || dy > N || dx < 1 || dx > M)
                    continue;
                if (visit[dy][dx] || graph[dy][dx] == 0)
                    continue;
                q.add(new int[] { dy, dx });
                visit[dy][dx] = true;
                area++;
            }
        }
        return area;
    }
}
