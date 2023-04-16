import java.io.*;
import java.util.*;

public class Boj_12852 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static List<Integer> trace = new ArrayList<>();
    static int[] dp, before;
    static int N, ans;

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        dp = new int[N + 1];
        before = new int[N + 1];
        Arrays.fill(dp, 1, N + 1, Integer.MAX_VALUE);
        bfs(N);
        
        sb.append(dp[1]).append("\n");

        int start = 1;
        while(start < N){
            trace.add(start);
            start = before[start];
        }

        trace.add(N);

        Collections.sort(trace, Collections.reverseOrder());
        for(int num : trace){
            sb.append(num).append(" ");
        }

        System.out.println(sb);
    }

    static void bfs(int start) {
        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        dp[start] = 0;
        before[start] = start;
        while (!q.isEmpty()) {
            int now = q.poll();
            if (now - 1 > 0 && dp[now - 1] > dp[now] + 1) {
                dp[now - 1] = dp[now] + 1;
                q.add(now - 1);
                before[now - 1] = now;
            }
            if (now % 2 == 0 && dp[now / 2] > dp[now] + 1) {
                dp[now / 2] = dp[now] + 1;
                q.add(now / 2);
                before[now / 2] = now;
            }
            if (now % 3 == 0 && dp[now / 3] > dp[now] + 1) {
                dp[now / 3] = dp[now] + 1;
                q.add(now / 3);
                before[now / 3] = now;
            }
        }
    }
}
