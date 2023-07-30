import java.io.*;
import java.util.*;

public class Boj_20040 {
    static class Node {
        int from, to;

        Node(int from, int to) {
            this.from = from;
            this.to = to;
        }
    }

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static List<Node> nodes = new ArrayList<>();
    static int[] parent;
    static int N, M;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        parent = new int[N];
        for (int i = 0; i < N; i++) {
            parent[i] = i;
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            nodes.add(new Node(Math.min(a, b), Math.max(a, b)));
            // nodes.add(new Node(b, a));
        }
        for (int i = 0; i < M; i++) {
            Node node = nodes.get(i);
            if (find(node.from) == find(node.to)) {
                System.out.println(i + 1);
                return;
            }

            union(node.from, node.to);
        }

        System.out.println(0);
    }

    static int find(int num) {
        if (parent[num] == num) {
            return num;
        }

        return parent[num] = find(parent[num]);
    }

    static void union(int from, int to) {
        parent[find(to)] = find(from);
    }
}
