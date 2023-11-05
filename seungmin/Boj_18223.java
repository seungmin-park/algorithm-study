import java.io.*;
import java.util.*;

public class Boj_18223 {
    static class Node {
        int to, dist;

        Node(int to, int dist) {
            this.to = to;
            this.dist = dist;
        }
    }

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static List<Node>[] graph;
    static int[] distance;
    static int V, E, P;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());
        P = Integer.parseInt(st.nextToken());

        graph = new ArrayList[V + 1];
        distance = new int[V + 1];
        for (int i = 1; i <= V; i++) {
            graph[i] = new ArrayList<>();
            distance[i] = Integer.MAX_VALUE;
        }

        for (int i = 1; i <= E; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int dist = Integer.parseInt(st.nextToken());

            graph[from].add(new Node(to, dist));
            graph[to].add(new Node(from, dist));
        }

        bfs(1);
        int mid = distance[P];
        int min = distance[V];

        Arrays.fill(distance, Integer.MAX_VALUE);
        bfs(P);
        mid += distance[V];

        if (mid == min) {
            System.out.println("SAVE HIM");
            return;
        }

        System.out.println("GOOD BYE");
    }

    static void bfs(int start) {
        PriorityQueue<Node> pq = new PriorityQueue<>((n1, n2) -> n1.dist - n2.dist);
        pq.add(new Node(start, 0));
        distance[start] = 0;

        while (!pq.isEmpty()) {
            Node now = pq.poll();
            if (distance[now.to] < now.dist) {
                continue;
            }
            for (Node next : graph[now.to]) {
                if (distance[next.to] > next.dist + distance[now.to]) {
                    distance[next.to] = next.dist + distance[now.to];
                    pq.add(new Node(next.to, distance[next.to]));
                }
            }
        }
    }
}
