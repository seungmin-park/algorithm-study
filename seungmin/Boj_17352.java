import java.io.*;
import java.util.*;

public class Boj_17352 {
    static class Node {
        int from, to;

        Node(int from, int to) {
            this.from = from;
            this.to = to;
        }
    }

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static List<Node> nodes = new ArrayList<>();
    static int[] parents;
    static int N;

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());

        parents = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            parents[i] = i;
        }

        for (int i = 1; i <= N - 2; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            nodes.add(new Node(from, to));
        }

        for (int i = 0; i < nodes.size(); i++) {
            Node node = nodes.get(i);
            if (find(node.from) == find(node.to)) {
                continue;
            }

            union(node.from, node.to);
        }

        for (int i = 1; i <= N; i++) {
            if (parents[i] == i) {
                sb.append(i).append(" ");
            }
        }

        System.out.println(sb);
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
