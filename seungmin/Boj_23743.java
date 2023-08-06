import java.io.*;
import java.util.*;

public class Boj_23743 {
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
    static int[] parents;
    static int N, M, ans;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        parents = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            parents[i] = i;
        }

        for (int i = 1; i <= M; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            nodes.add(new Node(from, to, weight));
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            nodes.add(new Node(0, i, Integer.parseInt(st.nextToken())));
        }

        Collections.sort(nodes, (n1, n2) -> n1.weight - n2.weight);

        for (Node node : nodes) {
            if (union(node.from, node.to)) {
                ans += node.weight;
            }
        }

        System.out.println(ans);
    }

    static int find(int target) {
        if (parents[target] == target) {
            return target;
        }
        return parents[target] = find(parents[target]);
    }

    static boolean union(int from, int to) {
        int fromParent = find(from);
        int toParent = find(to);
        if (fromParent == toParent) {
            return false;
        }
        parents[toParent] = fromParent;
        return true;
    }
}
