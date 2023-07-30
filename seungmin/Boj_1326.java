import java.io.*;
import java.util.*;

/**
 * 틀린 이유: 'a에서 b로 갈 수 없는 경우에는 -1을 출력한다.'
 * 문제를 꼼꼼히 읽기
 */
public class Boj_1326 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int[] bridge, dp;
    static int N, start, goal;

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        bridge = new int[N + 1];
        dp = new int[N + 1];

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            bridge[i] = Integer.parseInt(st.nextToken());
            dp[i] = Integer.MAX_VALUE;
        }

        st = new StringTokenizer(br.readLine());
        start = Integer.parseInt(st.nextToken());
        goal = Integer.parseInt(st.nextToken());

        bfs();

        System.out.println(dp[goal] == Integer.MAX_VALUE ? -1 : dp[goal]);
    }

    static void bfs() {
        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        dp[start] = 0;

        while (!q.isEmpty()) {
            int now = q.poll();
            int i = 0;
            while (true) {
                i++;
                int right = now + (bridge[now] * i);
                int left = now - (bridge[now] * i);
                if (left < 0 && right > N) {
                    break;
                }
                if (right <= N) {
                    if (dp[right] > dp[now] + 1) {
                        q.add(right);
                        dp[right] = dp[now] + 1;
                    }
                }
                if (left > 0) {
                    if (dp[left] > dp[now] + 1) {
                        q.add(left);
                        dp[left] = dp[now] + 1;
                    }
                }
            }
        }
    }
}
