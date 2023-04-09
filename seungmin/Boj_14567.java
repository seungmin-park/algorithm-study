import java.io.*;
import java.util.*;

public class Boj_14567 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static List<Integer>[] graph;
    static int[] indeg, ans;
    static int N, M;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        indeg = new int[N + 1];
        ans = new int[N + 1];
        graph = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 1; i <= M; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            graph[from].add(to);
            indeg[to]++;
        }

        bfs();

        for (int i = 1; i <= N; i++) {
            sb.append(ans[i]).append(" ");
        }

        System.out.println(sb);
    }

    static void bfs() {
        Queue<Integer> q = new LinkedList<>();
        for (int i = 1; i <= N; i++) {
            if (indeg[i] == 0) {
                q.add(i);
                ans[i] = 1;
            }
        }

        while (!q.isEmpty()) {
            int now = q.poll();
            for (int next : graph[now]) {
                indeg[next]--;
                if (indeg[next] == 0) {
                    ans[next] = ans[now] + 1;
                    q.add(next);
                }
            }
        }
    }
}
