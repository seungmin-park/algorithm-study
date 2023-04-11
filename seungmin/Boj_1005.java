import java.io.*;
import java.util.*;

public class Boj_1005 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static List<Integer>[] graph;
    static int[] delay, indeg, dp;
    static int N, K, W, T;

    public static void main(String[] args) throws IOException {
        T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            st = new StringTokenizer(br.readLine());

            N = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());

            graph = new ArrayList[N + 1];
            delay = new int[N + 1];
            indeg = new int[N + 1];
            dp = new int[N + 1];

            st = new StringTokenizer(br.readLine());
            for (int i = 1; i <= N; i++) {
                delay[i] = Integer.parseInt(st.nextToken());
                dp[i] = delay[i];
                graph[i] = new ArrayList<>();
            }

            for (int i = 1; i <= K; i++) {
                st = new StringTokenizer(br.readLine());
                int from = Integer.parseInt(st.nextToken());
                int to = Integer.parseInt(st.nextToken());

                graph[from].add(to);
                indeg[to]++;
            }
            W = Integer.parseInt(br.readLine());
            bfs();
            sb.append(dp[W]).append("\n");
        }

        System.out.println(sb);
    }

    static void bfs() {
        Queue<Integer> q = new LinkedList<>();
        for(int i = 1; i <= N; i++){
            if(indeg[i] == 0){
                q.offer(i);
            }
        }

        while (!q.isEmpty()) {
            int now = q.poll();
            for (int next : graph[now]) {
                dp[next] = Math.max(dp[next], delay[next] + dp[now]);
                indeg[next]--;
                if(indeg[next] == 0){
                    q.add(next);
                }
            }
        }
    }
}