import java.io.*;
import java.util.*;

public class Boj_10282 {
    static class Node {
        int to, weight;

        Node(int to, int weight) {
            this.to = to;
            this.weight = weight;
        }
    }

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static List<Node>[] nodes;
    static StringTokenizer st;
    static int[] distance;
    static int T, N, D, C;

    public static void main(String[] args) throws IOException {
        T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            D = Integer.parseInt(st.nextToken());
            C = Integer.parseInt(st.nextToken());
            nodes = new ArrayList[N + 1];
            distance = new int[N + 1];
            for (int i = 1; i <= N; i++) {
                nodes[i] = new ArrayList<>();
                distance[i] = Integer.MAX_VALUE;
            }

            for (int i = 1; i <= D; i++) {
                st = new StringTokenizer(br.readLine());
                int from = Integer.parseInt(st.nextToken());
                int to = Integer.parseInt(st.nextToken());
                int weight = Integer.parseInt(st.nextToken());
                nodes[to].add(new Node(from, weight));
            }

            bfs(C);

            int cnt = 0;
            int weight = -1;
            for (int i = 1; i <= N; i++) {
                if (distance[i] != Integer.MAX_VALUE) {
                    cnt++;
                    weight = Math.max(distance[i], weight);
                }
            }

            sb.append(cnt).append(" ").append(weight).append("\n");
            weight = 0;
        }

        System.out.println(sb);
    }

    static void bfs(int start) {
        Queue<Node> q = new LinkedList<>();
        q.add(new Node(start, 0));
        distance[start] = 0;

        while (!q.isEmpty()) {
            Node now = q.poll();
            if (distance[now.to] < now.weight) {
                continue;
            }
            for (Node next : nodes[now.to]) {
                if (distance[next.to] > distance[now.to] + next.weight) {
                    distance[next.to] = distance[now.to] + next.weight;
                    q.add(new Node(next.to, distance[next.to]));
                }
            }
        }
    }
}
