import java.io.*;
import java.util.*;

public class Boj_1325 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static List<Integer>[] computers;
    static boolean[] visited;
    static int[] dp;
    static int N, M, ans, cnt;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        computers = new ArrayList[N + 1];
        dp = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            computers[i] = new ArrayList<>();
        }

        for (int i = 1; i <= M; i++) {
            st = new StringTokenizer(br.readLine());
            int to = Integer.parseInt(st.nextToken());
            int from = Integer.parseInt(st.nextToken());

            computers[from].add(to);
        }

        int max = 0;
        for (int i = 1; i <= N; i++) {
            visited = new boolean[N + 1];
            int result = bfs(i);
            dp[i] = result;
            max = Math.max(max, result);
        }

        for (int i = 1; i <= N; i++) {
            if (dp[i] == max) {
                sb.append(i).append(" ");
            }
        }

        System.out.println(sb);
    }

    static int bfs(int start) {
        int cnt = 0;
        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        visited[start] = true;

        while (!q.isEmpty()) {
            int now = q.poll();
            for (int next : computers[now]) {
                if (visited[next]) {
                    cnt += dp[next];
                    continue;
                }
                q.add(next);
                visited[next] = true;
                cnt++;
            }
        }

        return cnt;
    }
}
