import java.io.*;
import java.util.*;

public class Boj_20010 {
    static class Node {
        int from, to, dist;

        Node(int from, int to, int dist) {
            this.from = from;
            this.to = to;
            this.dist = dist;
        }
    }

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static List<Node> nodes = new ArrayList<>();
    static List<Node>[] graph;
    static boolean[] visited;
    static int[] parents;
    static int N, K, ans, startNode, temp = Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        parents = new int[N];
        graph = new ArrayList[N];
        visited = new boolean[N];
        for (int i = 0; i < N; i++) {
            parents[i] = i;
            graph[i] = new ArrayList<>();
        }

        for (int k = 1; k <= K; k++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int dist = Integer.parseInt(st.nextToken());
            nodes.add(new Node(from, to, dist));
            nodes.add(new Node(to, from, dist));
        }

        Collections.sort(nodes, (n1, n2) -> n1.dist - n2.dist);
        for (Node node : nodes) {
            if (find(node.from) == find(node.to)) {
                continue;
            }

            ans += node.dist;
            graph[node.from].add(new Node(0, node.to, node.dist));
            graph[node.to].add(new Node(0, node.from, node.dist));
            union(node.from, node.to);
        }

        dfs(0, 0);
        visited = new boolean[N];
        temp = Integer.MIN_VALUE;

        dfs(startNode, 0);
        System.out.println(ans);
        System.out.println(temp);
    }

    static int find(int num) {
        if (num == parents[num]) {
            return num;
        }

        return parents[num] = find(parents[num]);
    }

    static void union(int from, int to) {
        int fromParent = find(from);
        int toParent = find(to);
        if (fromParent == toParent) {
            return;
        }
        parents[fromParent] = toParent;
    }

    static void dfs(int now, int total) {
        visited[now] = true;
        if (temp < total) {
            temp = total;
            startNode = now;
        }

        for (Node node : graph[now]) {
            if (visited[node.to]) {
                continue;
            }
            dfs(node.to, total + node.dist);
        }
    }
}
