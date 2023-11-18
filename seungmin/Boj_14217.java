import java.io.*;
import java.util.*;

public class Boj_14217 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static List<Integer>[] graph;
    static int[] distances;
    static int N, M, q;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        graph = new ArrayList[N + 1];
        distances = new int[N + 1];
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

        q = Integer.parseInt(br.readLine());
        for (int i = 1; i <= q; i++) {
            Arrays.fill(distances, 1, N + 1, -1);
            st = new StringTokenizer(br.readLine());
            int opt = Integer.parseInt(st.nextToken());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            if (opt == 1) {
                graph[from].add(to);
                graph[to].add(from);
            } else if (opt == 2) {
                graph[from].remove(graph[from].indexOf(to));
                graph[to].remove(graph[to].indexOf(from));
            }
            bfs();
            for (int j = 1; j <= N; j++) {
                sb.append(distances[j]).append(" ");
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }

    static void bfs() {
        Queue<Integer> q = new LinkedList<>();
        q.add(1);
        distances[1] = 0;

        while (!q.isEmpty()) {
            int now = q.poll();
            for (int next : graph[now]) {
                if (distances[next] != -1) {
                    continue;
                }
                q.add(next);
                distances[next] = distances[now] + 1;
            }
        }
    }
}
