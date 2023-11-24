import java.io.*;
import java.util.*;

public class Boj_14218 {
    static BufferedReader br = new BufferedReader(new InputStreamReader((System.in)));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static List<Integer>[] graph;
    static int[] visited;
    static int N, M, Q;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        graph = new ArrayList[N + 1];
        visited = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 1; i <= M; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());

            graph[from].add(to);
            graph[to].add(from);
        }

        Q = Integer.parseInt(br.readLine());
        for (int i = 1; i <= Q; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());

            graph[from].add(to);
            graph[to].add(from);
            Arrays.fill(visited, 1, N + 1, -1);

            bfs();

            for (int j = 1; j <= N; j++) {
                sb.append(visited[j]).append(" ");
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }

    static void bfs() {
        Queue<Integer> q = new LinkedList<>();
        q.add(1);
        visited[1] = 0;

        while (!q.isEmpty()) {
            int now = q.poll();
            for (int next : graph[now]) {
                if (visited[next] != -1) {
                    continue;
                }
                q.add(next);
                visited[next] = visited[now] + 1;
            }
        }
    }
}
