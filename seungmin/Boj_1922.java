import java.io.*;
import java.util.*;

public class Boj_1922 {
    static class Node implements Comparable<Node> {
        int from, to, weight;

        Node(int from, int to, int weight) {
            this.from = from;
            this.to = to;
            this.weight = weight;
        }

        @Override
        public int compareTo(Node n) {
            return this.weight - n.weight;
        }
    }

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static List<Node> networks = new ArrayList<>();
    static int[] parent;
    static int N, M, ans;

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        parent = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            parent[i] = i;
        }

        for (int i = 1; i <= M; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            networks.add(new Node(from, to, weight));
        }

        Collections.sort(networks);

        for (int i = 0; i < M; i++) {
            Node now = networks.get(i);

            if (find(now.from) == find(now.to)) {
                continue;
            }
            ans += now.weight;
            union(now.from, now.to);
        }

        System.out.println(ans);
    }

    static int find(int x) {
        if (x == parent[x]) {
            return x;
        }
        return parent[x] = find(parent[x]);
    }

    static void union(int x, int y) {
        x = find(x);
        y = find(y);

        if (x != y) {
            parent[y] = x;
        }
    }
}
