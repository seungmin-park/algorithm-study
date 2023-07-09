import java.io.*;
import java.util.*;

public class Boj_6118 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static List<Integer>[] graph;
    static int[] distance;
    static int N, M, max = Integer.MIN_VALUE, cnt;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        graph = new ArrayList[N + 1];
        distance = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
            distance[i] = -1;
        }

        for (int i = 1; i <= M; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            graph[from].add(to);
            graph[to].add(from);
        }

        bfs();

        for (int i = 1; i <= N; i++) {
            max = Math.max(max, distance[i]);
        }

        int idx = Integer.MAX_VALUE;
        for (int i = 1; i <= N; i++) {
            if (distance[i] == max) {
                idx = Math.min(idx, i);
                cnt++;
            }
        }

        sb.append(idx).append(" ").append(max).append(" ").append(cnt);

        System.out.println(sb);
    }

    static void bfs() {
        Queue<Integer> q = new LinkedList<>();
        q.add(1);
        distance[1] = 0;
        while (!q.isEmpty()) {
            int now = q.poll();
            for (int next : graph[now]) {
                if (distance[next] != -1) {
                    continue;
                }
                distance[next] = distance[now] + 1;
                q.add(next);
            }
        }
    }
}
