import java.io.*;
import java.util.*;

public class Boj_24446 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static List<Integer>[] graph;
    static int[] depths;
    static int N, M, R;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        graph = new ArrayList[N + 1];
        depths = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
            depths[i] = -1;
        }

        for (int i = 1; i <= M; i++) {
            st = new StringTokenizer(br.readLine());

            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            graph[from].add(to);
            graph[to].add(from);
        }

        bfs();

        for (int i = 1; i <= N; i++) {
            sb.append(depths[i]).append("\n");
        }

        System.out.println(sb);
    }

    static void bfs() {
        Queue<Integer> q = new LinkedList<>();
        q.add(R);
        q.add(0);

        depths[R] = 0;

        while (!q.isEmpty()) {
            int parent = q.poll();
            int depth = q.poll();
            for (int child : graph[parent]) {
                if (depths[child] != -1) {
                    continue;
                }
                depths[child] = depth + 1;
                q.add(child);
                q.add(depths[child]);
            }
        }
    }
}
