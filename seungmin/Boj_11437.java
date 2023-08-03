import java.io.*;
import java.util.*;

public class Boj_11437 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static List<Integer>[] graph;
    static boolean[] visited;
    static int[] parents, depths;
    static int N, M, ans;

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        graph = new ArrayList[N + 1];
        parents = new int[N + 1];
        depths = new int[N + 1];
        visited = new boolean[N + 1];

        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 1; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int p = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            graph[p].add(c);
            graph[c].add(p);
        }
        dfs(1, -1, 0);

        M = Integer.parseInt(br.readLine());
        for (int m = 1; m <= M; m++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            ans = lca(a, b);
            sb.append(ans).append("\n");
        }

        System.out.println(sb);
    }

    static void dfs(int now, int parent, int depth) {
        visited[now] = true;
        parents[now] = parent;
        depths[now] = depth;

        for (int next : graph[now]) {
            if (visited[next]) {
                continue;
            }
            dfs(next, now, depth + 1);
        }
    }

    static int lca(int a, int b) {
        while (depths[a] != depths[b]) {
            if (depths[a] > depths[b]) {
                a = parents[a];
            } else {
                b = parents[b];
            }
        }
        while (a != b) {
            a = parents[a];
            b = parents[b];
        }
        return a;
    }
}
