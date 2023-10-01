import java.io.*;
import java.util.*;

public class Boj_18232 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static List<Integer>[] tel;
    static int[] dist = new int[300_001];
    static int N, M, S, E;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        S = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());

        tel = new ArrayList[300_001];
        Arrays.fill(dist, -1);
        for (int i = 1; i <= 300_000; i++) {
            tel[i] = new ArrayList<>();

        }

        for (int i = 1; i <= M; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            tel[from].add(to);
            tel[to].add(from);
        }

        bfs();
        System.out.println(dist[E]);
    }

    static void bfs() {
        Queue<Integer> q = new ArrayDeque<>();
        q.add(S);
        dist[S] = 0;

        while (!q.isEmpty()) {
            int now = q.poll();
            int[] dir = { now - 1, now + 1 };
            for (int i = 0; i < 2; i++) {
                int next = dir[i];
                if (next < 1 || next > 300_000) {
                    continue;
                }
                if (dist[next] != -1) {
                    continue;
                }
                q.add(next);
                dist[next] = dist[now] + 1;
            }
            if (tel[now].size() > 0) {
                for (int next : tel[now]) {
                    if (next < 1 || next > 300_000) {
                        continue;
                    }
                    if (dist[next] != -1) {
                        continue;
                    }
                    q.add(next);
                    dist[next] = dist[now] + 1;
                }
            }
        }
    }
}
