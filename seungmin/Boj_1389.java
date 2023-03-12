import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Boj_1389 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static ArrayList<Integer>[] graph;
    static int[][] kevin;
    static boolean[] visit;
    static int N, M;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        graph = new ArrayList[N + 1];
        kevin = new int[N + 1][N + 1];
        visit = new boolean[N + 1];

        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 1; i <= M; i++) {
            st = new StringTokenizer(br.readLine());
            int to = Integer.parseInt(st.nextToken());
            int from = Integer.parseInt(st.nextToken());
            graph[to].add(from);
            graph[from].add(to);
        }

        for (int i = 1; i <= N; i++) {
            bfs(i);
            Arrays.fill(visit, false);
        }

        int min = Integer.MAX_VALUE;
        for (int i = 1; i <= N; i++) {
            int sum = 0;
            for (int j = 1; j <= N; j++) {
                sum += kevin[i][j];
            }
            min = Math.min(min, sum);
            kevin[i][0] = sum;
        }

        for (int i = 1; i <= N; i++) {
            if (min == kevin[i][0]) {
                System.out.println(i);
                return;
            }
        }
    }

    static void bfs(int start) {
        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        visit[start] = true;
        while (!q.isEmpty()) {
            int now = q.poll();
            for (int next : graph[now]) {
                if (visit[next]) {
                    continue;
                }
                kevin[start][next] = kevin[start][now] + 1;
                q.add(next);
                visit[next] = true;
            }
        }
    }
}
