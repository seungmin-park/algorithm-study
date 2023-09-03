import java.io.*;
import java.util.*;

public class Boj_1719 {
    static class Node {
        int to, dist;

        Node(int to, int dist) {
            this.to = to;
            this.dist = dist;
        }
    }

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static List<Node>[] nodes;
    static int[][] dist, dir;
    static int N, M;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        nodes = new ArrayList[N + 1];
        dist = new int[N + 1][N + 1];
        dir = new int[N + 1][N + 1];
        for (int i = 1; i <= N; i++) {
            nodes[i] = new ArrayList<>();
            Arrays.fill(dist[i], Integer.MAX_VALUE);
        }

        for (int i = 1; i <= M; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int dist = Integer.parseInt(st.nextToken());
            nodes[from].add(new Node(to, dist));
            nodes[to].add(new Node(from, dist));
        }

        for (int i = 1; i <= N; i++) {
            bfs(i);
        }
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                sb.append((dir[j][i] == 0 || dir[j][i] == Integer.MAX_VALUE) ? "-" : dir[j][i]).append(" ");
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }

    static void bfs(int start) {
        PriorityQueue<Node> q = new PriorityQueue<>((n1, n2) -> n1.dist - n2.dist);
        q.add(new Node(start, 0));
        dist[start][start] = 0;

        while (!q.isEmpty()) {
            Node now = q.poll();
            if (dist[start][now.to] < now.dist) {
                continue;
            }
            try {
                for (Node next : nodes[now.to]) {
                    if (dist[start][next.to] > dist[start][now.to] + next.dist) {
                        dist[start][next.to] = dist[start][now.to] + next.dist;
                        q.add(new Node(next.to, dist[start][next.to]));
                        dir[start][next.to] = now.to;
                    }
                }
            } catch (Exception e) {
                System.out.println("e: " + now.to);
            }
        }
    }
}
