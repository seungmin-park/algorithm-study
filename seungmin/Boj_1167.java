import java.io.*;
import java.util.*;

public class Boj_1167 {
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
    static boolean[] visited, isLeafNode;
    static int V, max, far;

    public static void main(String[] args) throws IOException {
        V = Integer.parseInt(br.readLine());
        tree = new ArrayList[V + 1];
        isLeafNode = new boolean[V + 1];
        visited = new boolean[V + 1];

        for (int i = 1; i <= V; i++) {
            tree[i] = new ArrayList<>();
        }

        for (int i = 1; i <= V; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = 0;
            while ((to = Integer.parseInt(st.nextToken())) != -1) {
                int dist = Integer.parseInt(st.nextToken());
                tree[from].add(new Node(to, dist));
            }
        }

        for (int i = 1; i <= V; i++) {
            if (tree[i].size() == 1) {
                isLeafNode[i] = true;
            }
        }

        dfs(1, 0);
        visited = new boolean[V + 1];
        dfs(far, 0);

        System.out.println(max);
    }

    static void dfs(int start, int dist) {
        if (max < dist) {
            max = dist;
            far = start;
        }
        visited[start] = true;
        for(Node next : tree[start]){
            if(visited[next.to]){
                continue;
            }
            dfs(next.to, dist + next.dist);
        }
    }
}
