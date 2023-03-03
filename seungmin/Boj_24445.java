import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Boj_24445 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static ArrayList<Integer>[] graph;
    static boolean[] visit;
    static int[] dist;
    static int N, M, R;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        visit = new boolean[N + 1];
        dist = new int[N + 1];
        graph = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 1; i <= M; i++) {
            st = new StringTokenizer(br.readLine());
            int form = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            graph[form].add(to);
            graph[to].add(form);
        }

        for (int i = 1; i <= N; i++) {
            Collections.sort(graph[i], Collections.reverseOrder());
        }

        bfs(R);
        for (int i = 1; i <= N; i++) {
            System.out.println(dist[i]);
        }
    }

    static void bfs(int start) {
        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        visit[start] = true;
        int d = 1;
        dist[start] = d;
        while (!q.isEmpty()) {
            int now = q.poll();
            for (int next : graph[now]) {
                if (visit[next]) {
                    continue;
                }
                q.add(next);
                visit[next] = true;
                dist[next] = ++d;
            }
        }
    }
}
