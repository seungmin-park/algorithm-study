import java.io.*;
import java.util.*;

public class Boj_18769 {
    static class Node {
        int from, to, value;

        Node(int from, int to, int value) {
            this.from = from;
            this.to = to;
            this.value = value;
        }
    }

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static List<Node> nodes;
    static int[] parents;
    static int T, R, C;

    public static void main(String[] args) throws IOException {
        T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            int ans = 0;
            st = new StringTokenizer(br.readLine());
            R = Integer.parseInt(st.nextToken());
            C = Integer.parseInt(st.nextToken());

            parents = new int[R * C + 1];
            nodes = new ArrayList<>();
            for (int i = 1; i <= R * C; i++) {
                parents[i] = i;
            }

            for (int c = 0; c < R; c++) {
                st = new StringTokenizer(br.readLine());
                int idx = c * C;
                for (int r = 1; r <= C - 1; r++) {
                    int from = r + idx;
                    int to = from + 1;
                    int value = Integer.parseInt(st.nextToken());
                    nodes.add(new Node(from, to, value));
                    nodes.add(new Node(to, from, value));
                }
            }

            for (int r = 1; r <= R - 1; r++) {
                st = new StringTokenizer(br.readLine());
                int idx = r * C - C;
                for (int c = 1; c <= C; c++) {
                    int from = c + idx;
                    int to = from + C;
                    int value = Integer.parseInt(st.nextToken());
                    nodes.add(new Node(from, to, value));
                    nodes.add(new Node(to, from, value));
                }
            }

            nodes.sort((n1, n2) -> n1.value - n2.value);
            for (Node node : nodes) {
                if (find(node.from) == find(node.to)) {
                    continue;
                }

                ans += node.value;
                union(node.from, node.to);
            }

            sb.append(ans).append("\n");
        }

        System.out.println(sb);
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

        parents[toParent] = fromParent;
    }
}
