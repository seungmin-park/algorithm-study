import java.io.*;
import java.util.*;

public class Boj_1967 {
    static class Node {
        int to, dist;

        Node(int to, int dist) {
            this.to = to;
            this.dist = dist;
        }
    }

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static List<Node>[] tree;
    static boolean[] isLeaf, visited;
    static int N, ans;

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());

        tree = new ArrayList[N + 1];
        isLeaf = new boolean[N + 1];
        for (int i = 1; i <= N; i++) {
            tree[i] = new ArrayList<>();
        }

        for (int i = 1; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int dist = Integer.parseInt(st.nextToken());
            tree[from].add(new Node(to, dist));
            tree[to].add(new Node(from, dist));
        }

        for (int i = 1; i <= N; i++) {
            if (tree[i].size() == 1) {
                isLeaf[i] = true;
            }
        }

        for (int i = 1; i <= N; i++) {
            if (isLeaf[i]) {
                visited = new boolean[N + 1];
                dfs(i, 0, i);
            }
        }

        System.out.println(ans);
    }

    static void dfs(int start, int dist, int parent) {
        visited[start] = true;
        if (tree[start].size() == 1 && start != parent) {
            ans = Math.max(ans, dist);
            return;
        }
        for (Node next : tree[start]) {
            if (visited[next.to]) {
                continue;
            }
            dfs(next.to, dist + next.dist, start);
        }
    }
}
