import java.io.*;
import java.util.*;

public class Boj_24484 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static List<Integer>[] graph;
    static int N, M, R;
    static long[] d;
    static long ans, dist = 1;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        graph = new ArrayList[N + 1];
        d = new long[N + 1];
        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
            d[i] = -1;
        }

        for (int i = 1; i <= M; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            graph[from].add(to);
            graph[to].add(from);
        }

        for (int i = 1; i <= N; i++) {
            Collections.sort(graph[i], Collections.reverseOrder());
        }

        dfs(R, 0);

        ans = Arrays.stream(d)
                .filter(e -> e != -1)
                .sum();

        System.out.println(ans);
    }

    static void dfs(int start, int depth) {
        d[start] = depth * dist++;

        for (int next : graph[start]) {
            if (d[next] != -1) {
                continue;
            }
            dfs(next, depth + 1);
        }
    }
}
