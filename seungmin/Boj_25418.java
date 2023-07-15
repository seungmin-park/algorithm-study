import java.io.*;
import java.util.*;

public class Boj_25418 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int[] dp = new int[1_000_001];
    static int A, K;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        A = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        Arrays.fill(dp, 1, 1_000_001, -1);

        bfs();

        System.out.println(dp[K]);
    }

    static void bfs() {
        Queue<Integer> q = new LinkedList<>();
        q.add(A);
        dp[A] = 0;

        while (!q.isEmpty()) {
            int now = q.poll();
            for (int i = 0; i < 2; i++) {
                int next = 0;
                if (i == 0) {
                    next = now + 1;
                } else {
                    next = now * 2;
                }
                if (next < 1 || next > 1_000_000) {
                    continue;
                }
                if (dp[next] != -1) {
                    continue;
                }
                dp[next] = dp[now] + 1;
                q.add(next);
            }
        }
    }
}
