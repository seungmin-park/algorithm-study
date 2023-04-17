import java.io.*;
import java.util.*;

public class Boj_2056 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static List<Integer>[] tasks;
    static int[] dp, time, indeg;
    static int N, ans;

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        tasks = new ArrayList[N + 1];
        dp = new int[N + 1];
        time = new int[N + 1];
        indeg = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            tasks[i] = new ArrayList<>();
        }

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            time[i] = Integer.parseInt(st.nextToken());
            dp[i] = time[i];
            int deg = Integer.parseInt(st.nextToken());
            indeg[i] = deg;
            if (deg < 1)
                continue;

            for (int j = 1; j <= deg; j++) {
                int parent = Integer.parseInt(st.nextToken());
                tasks[parent].add(i);
            }
        }
        bfs();

        for (int d : dp) {
            ans = Math.max(ans, d);
        }

        System.out.println(ans);
    }

    static void bfs() {
        Queue<Integer> q = new LinkedList<>();
        for (int i = 1; i <= N; i++) {
            if (indeg[i] == 0) {
                q.add(i);
            }
        }

        while (!q.isEmpty()) {
            int now = q.poll();
            for (int next : tasks[now]) {
                indeg[next]--;
                dp[next] = Math.max(dp[next], time[next] + dp[now]);
                ans = Math.max(dp[next], ans);
                if (indeg[next] == 0) {
                    q.add(next);
                }
            }
        }
    }
}
