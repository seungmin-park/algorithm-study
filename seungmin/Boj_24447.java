import java.io.*;
import java.util.*;

public class Boj_24447 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static List<Integer>[] graph;
    static int N, M, start, nowCnt = 1;
    static long[] depth, visited;
    static long ans;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        start = Integer.parseInt(st.nextToken());

        depth = new long[N + 1];
        visited = new long[N + 1];
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

        bfs();
        for (int i = 1; i <= N; i++) {
            ans += depth[i] * visited[i];
        }

        System.out.println(ans);
    }

    static void bfs() {
        Queue<Integer> q = new LinkedList<>();
        q.add(start);

        depth[start] = 0;
        visited[start] = nowCnt;
        while (!q.isEmpty()) {
            int now = q.poll();
            for (int next : graph[now]) {
                if (depth[next] != -1) {
                    continue;
                }

                q.add(next);
                depth[next] = depth[now] + 1;
                visited[next] = ++nowCnt;
            }
        }
    }
}
