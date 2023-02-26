import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Boj_1753 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    static ArrayList<Edge>[] edges;
    static int[] dist;
    static int V, E, K;

    static class Edge implements Comparable<Edge> {
        int edge, weight;

        Edge(int edge, int weight) {
            this.edge = edge;
            this.weight = weight;
        }

        @Override
        public int compareTo(Edge e) {
            return this.weight - e.weight;
        }
    }


    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());

        dist = new int[V + 1];
        edges = new ArrayList[V + 1];

        for (int i = 1; i <= V; i++) {
            dist[i] = Integer.MAX_VALUE;
            edges[i] = new ArrayList<>();
        }

        K = Integer.parseInt(br.readLine());

        for (int i = 1; i <= E; i++) {
            st = new StringTokenizer(br.readLine());
            int form = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            edges[form].add(new Edge(to, weight));
        }

        bfs(K);
        for (int i = 1; i <= V; i++) {
            sb.append(dist[i] == Integer.MAX_VALUE ? "INF" : dist[i])
                    .append("\n");
        }

        System.out.println(sb.toString());
    }

    static void bfs(int start) {
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        pq.add(new Edge(start, 0));
        dist[start] = 0;

        while (!pq.isEmpty()) {
            Edge now = pq.poll();
            if (dist[now.edge] < now.weight) {
                continue;
            }
            for (Edge next : edges[now.edge]) {
                if (dist[next.edge] > dist[now.edge] + next.weight) {
                    dist[next.edge] = dist[now.edge] + next.weight;
                    pq.add(new Edge(next.edge, dist[next.edge]));
                }
            }
        }
    }
}
