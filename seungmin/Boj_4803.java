import java.io.*;
import java.util.*;

public class Boj_4803 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static List<Integer>[] graph;
    static boolean[] visited;
    static boolean isCycled;
    static int N, M, T, nodeCnt, edgeCnt, treeCnt;

    public static void main(String[] args) throws IOException {
        while (true) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            if (N == 0 && M == 0) {
                break;
            }
            T++;
            treeCnt = 0;
            graph = new ArrayList[N + 1];
            visited = new boolean[N + 1];
            for (int i = 1; i <= N; i++) {
                graph[i] = new ArrayList<>();
            }
            for (int i = 1; i <= M; i++) {
                st = new StringTokenizer(br.readLine());
                int from = Integer.parseInt(st.nextToken());
                int to = Integer.parseInt(st.nextToken());
                graph[from].add(to);
                graph[to].add(from);
            }

            for (int i = 1; i <= N; i++) {
                edgeCnt = nodeCnt = 0;
                isCycled = false;
                if (visited[i]) {
                    continue;
                }
                dfs(i, -1);
                if (!isCycled && nodeCnt == edgeCnt) {
                    treeCnt++;
                }
            }
            sb.append("Case ").append(T).append(": ");
            if (treeCnt == 0) {
                sb.append("No trees.");
            } else if (treeCnt == 1) {
                sb.append("There is one tree.");
            } else {
                sb.append("A forest of ").append(treeCnt).append(" trees.");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }

    static void dfs(int start, int parent) {
        visited[start] = true;
        for (int next : graph[start]) {
            if (next == parent) {
                continue;
            }
            if (visited[next]) {
                isCycled = true;
                return;
            }
            edgeCnt++;
            nodeCnt++;
            dfs(next, start);
        }
    }
}
