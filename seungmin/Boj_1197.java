import java.io.*;
import java.util.*;

public class Boj_1197 {
    static class Node {
        int from, to, weight;

        Node(int from, int to, int weight) {
            this.from = from;
            this.to = to;
            this.weight = weight;
        }
    }

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static List<Node> nodes = new ArrayList<>();
    static int[] parent;
    static int V, E, ans;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());

        parent = new int[V + 1];
        for (int i = 1; i <= V; i++) {
            parent[i] = i;
        }

        for (int i = 1; i <= E; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            nodes.add(new Node(from, to, weight));
        }

        Collections.sort(nodes, (n1, n2) -> n1.weight - n2.weight);

        for (Node node : nodes) {
            if (find(node.from) == find(node.to)) {
                continue;
            }

            union(node.from, node.to);
            ans += node.weight;
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
        int fromParent = find(from);
        int toParent = find(to);
        if (fromParent == toParent) {
            return;
        }
        parent[toParent] = fromParent;
    }
}
