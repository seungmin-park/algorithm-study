import java.io.*;
import java.util.*;

public class Boj_12851 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static int[] dist = new int[100_001];
    static int N, K, cand;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        Arrays.fill(dist, -1);

        bfs();
        sb.append(dist[K]).append("\n").append(cand);
        System.out.println(sb);
    }

    static void bfs() {
        Queue<Integer> q = new LinkedList<>();
        q.add(N);
        dist[N] = 0;

        while (!q.isEmpty()) {
            int now = q.poll();
            if (now == K) {
                cand++;
                continue;
            }
            int[] nexts = { now - 1, now + 1, now * 2 };
            for (int i = 0; i < 3; i++) {
                int next = nexts[i];
                if (next < 0 || next > 100_000) {
                    continue;
                }
                if (dist[next] != -1) {
                    if (dist[next] != dist[now] + 1) {
                        continue;
                    }
                }

                q.add(next);
                dist[next] = dist[now] + 1;
            }
        }
    }
}
