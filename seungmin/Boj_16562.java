import java.io.*;
import java.util.*;

public class Boj_16562 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static List<Integer>[] firends;
    static boolean[] visited;
    static int[] costs;
    static int N, M, K;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        costs = new int[N + 1];
        visited = new boolean[N + 1];
        firends = new ArrayList[N + 1];

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            firends[i] = new ArrayList<>();
            costs[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 1; i <= M; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            firends[from].add(to);
            firends[to].add(from);
        }

        int cost = 0;
        for (int i = 1; i <= N; i++) {
            if (visited[i]) {
                continue;
            }
            cost += bfs(i);
        }
        if (cost > K) {
            System.out.println("Oh no");
        } else {
            System.out.println(cost);
        }
    }

    static int bfs(int start) {
        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        visited[start] = true;
        int cost = costs[start];

        while (!q.isEmpty()) {
            int now = q.poll();
            for (int next : firends[now]) {
                if (visited[next]) {
                    continue;
                }
                q.add(next);
                visited[next] = true;
                cost = Math.min(cost, costs[next]);
            }
        }

        return cost;
    }
}
