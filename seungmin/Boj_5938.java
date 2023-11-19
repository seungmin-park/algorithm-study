import java.io.*;
import java.util.*;

public class Boj_5938 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static List<Integer>[] graph;
    static int[] dist;
    static int N, M;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        dist = new int[N + 1];
        graph = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            dist[i] = -1;
            graph[i] = new ArrayList<>();
        }

        for (int i = 1; i <= M; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            graph[from].add(to);
            graph[to].add(from);
        }

        bfs();
        boolean flag = true;
        for (int i = 1; i <= N; i++) {
            if (dist[i] == -1) {
                flag = false;
                sb.append(i).append("\n");
            }
        }

        if (flag) {
            System.out.println(0);
        } else {
            System.out.println(sb);
        }
    }

    static void bfs() {
        Queue<Integer> q = new LinkedList<>();
        q.add(1);
        dist[1] = 0;

        while (!q.isEmpty()) {
            int now = q.poll();
            for (int next : graph[now]) {
                if (dist[next] != -1) {
                    continue;
                }
                q.add(next);
                dist[next] = dist[now] + 1;
            }
        }
    }
}
