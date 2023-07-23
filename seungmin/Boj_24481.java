import java.io.*;
import java.util.*;

public class Boj_24481 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static List<Integer>[] graph;
    static int[] depth;
    static int N, M, R;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        depth = new int[N + 1];
        graph = new ArrayList[N + 1];

        for (int i = 1; i <= N; i++) {
            depth[i] = -1;
            graph[i] = new ArrayList<>();
        }

        for (int i = 1; i <= M; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            graph[from].add(to);
            graph[to].add(from);
        }

        for (int i = 1; i <= N; i++) {
            Collections.sort(graph[i]);
        }

        depth[R] = 0;
        dfs(R);

        for (int i = 1; i <= N; i++) {
            sb.append(depth[i]).append("\n");
        }

        System.out.println(sb);
    }

    static void dfs(int start) {
        for (int next : graph[start]) {
            if (depth[next] != -1) {
                continue;
            }
            depth[next] = depth[start] + 1;
            dfs(next);
        }
    }
}
