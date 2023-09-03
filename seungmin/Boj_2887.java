import java.io.*;
import java.util.*;

public class Boj_2887 {
    static class Star {
        int num, z, y, x;

        Star(int num, int z, int y, int x) {
            this.num = num;
            this.z = z;
            this.y = y;
            this.x = x;
        }
    }

    static class Node {
        int from, to, value;

        Node(int from, int to, int value) {
            this.from = from;
            this.to = to;
            this.value = value;
        }
    }

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static List<Star> stars = new ArrayList<>();
    static ArrayList<Node> nodes = new ArrayList<>();
    static int[] parent;
    static int N, ans;

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        parent = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            parent[i] = i;
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int z = Integer.parseInt(st.nextToken());
            stars.add(new Star(i, z, y, x));
        }

        Collections.sort(stars, (s1, s2) -> s1.x - s2.x);
        for (int i = 0; i < N - 1; i++) {
            Star from = stars.get(i);
            Star to = stars.get(i + 1);
            nodes.add(new Node(from.num, to.num, Math.abs(from.x - to.x)));
        }

        Collections.sort(stars, (s1, s2) -> s1.y - s2.y);
        for (int i = 0; i < N - 1; i++) {
            Star from = stars.get(i);
            Star to = stars.get(i + 1);
            nodes.add(new Node(from.num, to.num, Math.abs(from.y - to.y)));
        }

        Collections.sort(stars, (s1, s2) -> s1.z - s2.z);
        for (int i = 0; i < N - 1; i++) {
            Star from = stars.get(i);
            Star to = stars.get(i + 1);
            nodes.add(new Node(from.num, to.num, Math.abs(from.z - to.z)));
        }

        Collections.sort(nodes, (n1, n2) -> n1.value - n2.value);

        for (Node node : nodes) {
            if (find(node.from) == find(node.to)) {
                continue;
            }
            union(node.from, node.to);
            ans += node.value;
        }

        System.out.println(ans);
    }

    static int find(int target) {
        if (parent[target] == target) {
            return target;
        }

        return parent[target] = find(parent[target]);
    }

    static void union(int from, int to) {
        int fromParent = find(from);
        int toParent = find(to);
        if (toParent == fromParent) {
            return;
        }
        parent[toParent] = fromParent;
    }
}
