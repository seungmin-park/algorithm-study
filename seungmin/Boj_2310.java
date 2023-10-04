import java.io.*;
import java.util.*;

public class Boj_2310 {
    static class Node {
        String type;
        int neccesery;

        Node(String type, int neccesery) {
            this.type = type;
            this.neccesery = neccesery;
        }
    }

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static List<Integer>[] graph;
    static Node[] nodes;
    static boolean[] visited;
    static boolean flag;
    static int N;
    static final String EMPTY = "E";
    static final String TOROL = "T";
    static final String LEFRICON = "L";

    public static void main(String[] args) throws IOException {
        while ((N = Integer.parseInt(br.readLine())) != 0) {
            graph = new ArrayList[N + 1];
            nodes = new Node[N + 1];
            visited = new boolean[N + 1];
            flag = false;

            for (int i = 1; i <= N; i++) {
                graph[i] = new ArrayList<>();
            }

            for (int i = 1; i <= N; i++) {
                st = new StringTokenizer(br.readLine());
                String type = st.nextToken();
                int neccesery = Integer.parseInt(st.nextToken());
                nodes[i] = new Node(type, neccesery);
                int next = -1;
                while ((next = Integer.parseInt(st.nextToken())) != 0) {
                    graph[i].add(next);
                    // graph[next].add(i);
                }
            }

            if (nodes[1].type.equals(TOROL)) {
                flag = false;
            } else {
                visited[1] = true;
                dfs(1, 0);
            }

            if (flag) {
                sb.append("Yes");
            } else {
                sb.append("No");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }

    static void dfs(int now, int gold) {
        if (now == N) {
            flag = true;
            return;
        }
        for (int next : graph[now]) {
            if (visited[next]) {
                continue;
            }
            Node nextDir = nodes[next];
            if (nextDir.type.equals(TOROL)) {
                if (gold - nextDir.neccesery < 0) {
                    continue;
                }
                visited[next] = true;
                dfs(next, gold - nextDir.neccesery);
                visited[next] = false;
            } else if (nextDir.type.equals(LEFRICON)) {
                visited[next] = true;
                if (gold < nextDir.neccesery) {
                    dfs(next, nextDir.neccesery);
                } else {
                    dfs(next, gold);
                }
                visited[next] = false;
            } else {
                visited[next] = true;
                dfs(next, gold);
                visited[next] = false;
            }

        }
    }
}
