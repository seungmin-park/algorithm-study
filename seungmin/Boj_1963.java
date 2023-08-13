import java.io.*;
import java.util.*;

public class Boj_1963 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static int[] dp;
    static int T, init, goal;

    public static void main(String[] args) throws IOException {
        T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            st = new StringTokenizer(br.readLine());
            init = Integer.parseInt(st.nextToken());
            goal = Integer.parseInt(st.nextToken());

            dp = new int[10_001];
            Arrays.fill(dp, 1, 10_000, -1);

            bfs();

            sb.append(dp[goal] == -1 ? "Impossible" : dp[goal]).append("\n");
        }

        System.out.println(sb);
    }

    static void bfs() {
        Queue<Integer> q = new LinkedList<>();
        q.add(init);
        dp[init] = 0;

        while (!q.isEmpty()) {
            int now = q.poll();
            for (int idx = 1; idx <= 4; idx++) {
                StringBuffer t = new StringBuffer(String.valueOf(now));
                t.setCharAt(4 - idx, '0');
                int temp = Integer.parseInt(t.toString());
                for (int i = 0; i <= 9; i++) {
                    if (idx == 4 && i == 0) {
                        continue;
                    }
                    boolean flag = true;
                    int next = temp + ((int) Math.pow(10, idx - 1) * i);
                    if (dp[next] != -1) {
                        continue;
                    }
                    for (int cand = 2; cand <= Math.sqrt(next); cand++) {
                        if (next % cand == 0) {
                            flag = false;
                            break;
                        }
                    }
                    if (flag) {
                        dp[next] = dp[now] + 1;
                        q.add(next);
                    }
                }
            }
        }
    }
}
