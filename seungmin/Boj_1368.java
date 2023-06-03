import java.io.*;
import java.util.*;

public class Boj_1368 {
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
    static int[] directCosts, parent;
    static int N, ans, directCnt;

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        directCosts = new int[N + 1];
        parent = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            directCosts[i] = Integer.parseInt(br.readLine());
            parent[i] = i;
        }

        for (int col = 1; col <= N; col++) {
            st = new StringTokenizer(br.readLine());
            for (int row = 1; row <= N; row++) {
                int cost = Integer.parseInt(st.nextToken());
                if (col == row) {
                    nodes.add(new Node(0, col, directCosts[col]));
                    continue;
                }
                nodes.add(new Node(col, row, cost));
            }
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
