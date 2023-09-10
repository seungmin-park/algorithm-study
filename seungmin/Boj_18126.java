import java.io.*;
import java.util.*;

public class Boj_18126 {
    static class Node {
        int to, dist;

        Node(int to, int dist) {
            this.to = to;
            this.dist = dist;
        }
    }

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static List<Node>[] graph;
    static long ans = Long.MIN_VALUE;
    static boolean[] visited;
    static int N;

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());

        graph = new ArrayList[N + 1];
        visited = new boolean[N + 1];
        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 1; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int dist = Integer.parseInt(st.nextToken());
            graph[from].add(new Node(to, dist));
            graph[to].add(new Node(from, dist));
        }

        dfs(1, 0);

        System.out.println(ans);
    }

    static void dfs(int now, long dist) {
        visited[now] = true;
        ans = Math.max(dist, ans);

        for (Node next : graph[now]) {
            if (visited[next.to]) {
                continue;
            }

            dfs(next.to, dist + next.dist);
        }
    }
}
