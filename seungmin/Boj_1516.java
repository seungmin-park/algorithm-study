import java.io.*;
import java.util.*;

public class Boj_1516 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static List<Integer>[] graph;
    static int[] distance, indeg, ans;
    static int N;

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        distance = new int[N + 1];
        indeg = new int[N + 1];
        ans = new int[N + 1];
        graph = new ArrayList[N + 1];

        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            int w = Integer.parseInt(st.nextToken());
            distance[i] = w;
            int pre = 0;
            while ((pre = Integer.parseInt(st.nextToken())) != -1) {
                graph[pre].add(i);
                indeg[i]++;
            }
        }

        bfs();
        for (int i = 1; i <= N; i++) {
            sb.append(ans[i]).append("\n");
        }

        System.out.println(sb);
    }

    static void bfs() {
        Queue<Integer> q = new LinkedList<>();
        for (int i = 1; i <= N; i++) {
            if (indeg[i] == 0) {
                q.add(i);
                ans[i] = distance[i];
            }
        }

        while (!q.isEmpty()) {
            int now = q.poll();
            for (int next : graph[now]) {
                indeg[next]--;
                ans[next] = Math.max(ans[next], distance[next] + ans[now]);
                if (indeg[next] == 0) {
                    q.add(next);
                }
            }
        }
    }
}
