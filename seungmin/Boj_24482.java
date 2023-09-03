import java.io.*;
import java.util.*;

public class Boj_24482 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static List<Integer>[] graph;
    static int[] visited;
    static int N, M, R;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

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

        Arrays.fill(visited, -1);
        for (int i = 1; i <= N; i++) {
            Collections.sort(graph[i], Collections.reverseOrder());
        }

        dfs(R, 0);

        for (int i = 1; i <= N; i++) {
            sb.append(visited[i]).append("\n");
        }

        System.out.println(sb);
    }

    static void dfs(int start, int parent) {
        visited[start] = visited[parent] + 1;

        for (int next : graph[start]) {
            if (visited[next] != -1) {
                continue;
            }
            dfs(next, start);
        }
    }
}
