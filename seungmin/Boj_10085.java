import java.io.*;
import java.util.*;

public class Boj_10085 {
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
    static Node[] nodes;
    static int[] parents;
    static int p, w, start, end, ans = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        p = Integer.parseInt(st.nextToken());
        w = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        start = Integer.parseInt(st.nextToken());
        end = Integer.parseInt(st.nextToken());

        nodes = new Node[w];
        parents = new int[p];
        for (int i = 0; i < p; i++) {
            parents[i] = i;
        }

        for (int i = 0; i < w; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int dist = Integer.parseInt(st.nextToken());
            nodes[i] = new Node(from, to, dist);
            nodes[i] = new Node(to, from, dist);
        }

        Arrays.sort(nodes, (n1, n2) -> n2.dist - n1.dist);

        for (Node node : nodes) {
            if (find(start) == find(end)) {
                break;
            }
            if (find(node.from) == find(node.to)) {
                continue;
            }

            ans = Math.min(ans, node.dist);
            union(node.from, node.to);
        }

        System.out.println(ans);
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
}
