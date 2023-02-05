import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Boj_1260_AdjacentMatrix {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static int[][] graph;
    static boolean[] visit;
    static int N, M, V;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        V = Integer.parseInt(st.nextToken());

        graph = new int[N + 1][N + 1];
        visit = new boolean[N + 1];

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int to = Integer.parseInt(st.nextToken());
            int from = Integer.parseInt(st.nextToken());
            graph[to][from] = 1;
            graph[from][to] = 1;
        }

        dfs(V);
        sb.append("\n");
        Arrays.fill(visit, false);
        bfs(V);
        System.out.println(sb);
    }

    static void dfs(int start) {
        visit[start] = true;
        sb.append(start).append(" ");
        for (int next : graph[start]) {
            if (visit[next] || next == 0) {
                continue;
            }
            bfs(next);
        }
    }

    static void bfs(int start) {
        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        visit[start] = true;

        while (!q.isEmpty()) {
            Integer current = q.poll();
            sb.append(current).append(" ");
            for (int next : graph[current]) {
                if (visit[next] || next == 0) {
                    continue;
                }
                q.add(next);
            }
        }
    }
}
