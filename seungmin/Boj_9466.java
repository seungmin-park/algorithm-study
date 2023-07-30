import java.io.*;
import java.util.*;

public class Boj_9466 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static List<Integer>[] graph;
    static boolean[] visited, grouped;
    static int T, N, cnt;

    public static void main(String[] args) throws IOException {
        T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            cnt = 0;
            N = Integer.parseInt(br.readLine());
            graph = new ArrayList[N + 1];
            visited = new boolean[N + 1];
            grouped = new boolean[N + 1];

            for (int i = 1; i <= N; i++) {
                graph[i] = new ArrayList<>();
            }

            st = new StringTokenizer(br.readLine());
            for (int i = 1; i <= N; i++) {
                int to = Integer.parseInt(st.nextToken());
                graph[i].add(to);
            }

            for (int i = 1; i <= N; i++) {
                dfs(i);
            }

            sb.append(N - cnt).append("\n");
        }

        System.out.println(sb);
    }

    static void dfs(int start) {
        visited[start] = true;

        int next = graph[start].get(0);
        if (!visited[next]) {
            dfs(next);
        } else {
            if (!grouped[next]) {
                cnt++;
                while (next != start) {
                    cnt++;
                    next = graph[next].get(0);
                }
            }
        }
        grouped[start] = true;
    }
}
