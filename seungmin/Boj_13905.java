import java.io.*;
import java.util.*;
import java.util.stream.Stream;

public class Boj_13905 {
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
    static int N, M, start, end, ans = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        parents = new int[N + 1];

        st = new StringTokenizer(br.readLine());
        start = Integer.parseInt(st.nextToken());
        end = Integer.parseInt(st.nextToken());

        for (int i = 1; i <= N; i++) {
            parents[i] = i;
        }

        for (int i = 1; i <= M; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            nodes.add(new Node(from, to, weight));
            nodes.add(new Node(to, from, weight));
        }

        Collections.sort(nodes, (n1, n2) -> n2.weight - n1.weight);

        for (Node node : nodes) {
            if (find(node.from) == find(node.to)) {
                continue;
            }

            ans = Math.min(ans, node.weight);
            union(node.from, node.to);
            if (find(start) == find(end)) {
                break;
            }
        }

        System.out.println(find(start) == find(end) ? ans : 0);
    }

    static int find(int num) {
        if (parents[num] == num) {
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

        parents[toParent] = fromParent;
    }
}
