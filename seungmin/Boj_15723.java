import java.io.*;
import java.util.*;

public class Boj_15723 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static List<Integer>[] graph;
    static boolean[] visited;
    static int N, M;

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        visited = new boolean[26 + 1];
        graph = new ArrayList[26 + 1];

        for (int i = 1; i <= 26; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            int from = st.nextToken().charAt(0) - 96;
            st.nextToken();
            int to = st.nextToken().charAt(0) - 96;
            graph[from].add(to);
        }

        M = Integer.parseInt(br.readLine());
        for (int i = 1; i <= M; i++) {
            st = new StringTokenizer(br.readLine());
            int from = st.nextToken().charAt(0) - 96;
            st.nextToken();
            int to = st.nextToken().charAt(0) - 96;
            if (bfs(from, to)) {
                sb.append("T");
            } else {
                sb.append("F");
            }
            sb.append("\n");

            Arrays.fill(visited, 1, N + 1, false);
        }

        System.out.println(sb);
    }

    static boolean bfs(int from, int to) {
        Queue<Integer> q = new LinkedList<>();
        q.add(from);
        visited[from] = false;

        while (!q.isEmpty()) {
            int now = q.poll();
            for (int next : graph[now]) {
                if (next == to) {
                    return true;
                }
                if (visited[next])
                    continue;
                q.add(next);
            }
        }

        return false;
    }
}
