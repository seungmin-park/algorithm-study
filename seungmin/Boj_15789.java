import java.io.*;
import java.util.*;

public class Boj_15789 {
    static class Node {
        int from, to;

        Node(int from, int to) {
            this.from = from;
            this.to = to;
        }
    }

    static class Pair {
        int idx, count;

        Pair(int idx, int count) {
            this.idx = idx;
            this.count = count;
        }
    }

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static List<Node> nodes = new ArrayList<>();
    static List<Pair> pairs = new ArrayList<>();
    static int[] counts, parents;
    static int N, M, C, H, K, ans;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        counts = new int[N + 1];
        parents = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            parents[i] = i;
        }

        for (int i = 1; i <= M; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            nodes.add(new Node(from, to));
        }

        for (Node node : nodes) {
            if (find(node.from) == find(node.to)) {
                continue;
            }

            union(node.from, node.to);
        }

        for (int i = 1; i <= N; i++) {
            int parent = find(i);
            counts[parent]++;
        }

        st = new StringTokenizer(br.readLine());
        C = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        ans = counts[find(C)];
        int HParent = find(H);

        for (int i = 1; i <= N; i++) {
            int parent = find(i);
            if (parent == HParent) {
                continue;
            }
            pairs.add(new Pair(i, counts[i]));
        }

        Collections.sort(pairs, (p1, p2) -> p2.count - p1.count);

        for (Pair pair : pairs) {
            if (K < 1) {
                break;
            }
            if (find(C) == find(pair.idx)) {
                continue;
            }

            union(C, pair.idx);
            ans += pair.count;
            K--;
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

        parents[toParent] = fromParent;
    }
}
