import java.io.*;
import java.util.*;

public class Boj_10423 {
    static class Node {
        int from, to, cost;

        Node(int from, int to, int cost) {
            this.from = from;
            this.to = to;
            this.cost = cost;
        }
    }

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static List<Node> nodes = new ArrayList<>();
    static int[] parent;
    static int N, M, K, ans;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        parent = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            parent[i] = i;
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= K; i++) {
            nodes.add(new Node(0, Integer.parseInt(st.nextToken()), 0));
        }

        for (int i = 1; i <= M; i++) {
            st = new StringTokenizer(br.readLine());
            int to = Integer.parseInt(st.nextToken());
            int from = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            nodes.add(new Node(to, from, cost));
        }

        Collections.sort(nodes, (n1, n2) -> n1.cost - n2.cost);

        for (Node node : nodes) {
            if (find(node.from) == find(node.to)) {
                continue;
            }
            union(node.from, node.to);
            ans += node.cost;
        }

        System.out.println(ans);
    }

    static int find(int num) {
        if (num == parent[num]) {
            return num;
        }

        return parent[num] = find(parent[num]);
    }

    static void union(int from, int to) {
        parent[find(to)] = find(from);
    }
}
