import java.io.*;
import java.util.*;

public class Boj_20007 {
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
    static boolean[] visited;
    static int[] distance;
    static int N, M, X, Y, ans = 1;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());
        Y = Integer.parseInt(st.nextToken());

        distance = new int[N];
        graph = new ArrayList[N];
        visited = new boolean[N];
        for (int i = 0; i < N; i++) {
            graph[i] = new ArrayList<>();
            distance[i] = Integer.MAX_VALUE;
        }

        for (int i = 1; i <= M; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int dist = Integer.parseInt(st.nextToken());

            graph[from].add(new Node(to, dist));
            graph[to].add(new Node(from, dist));
        }

        bfs();

        Arrays.sort(distance);

        int sum = 0;
        for (int i = 0; i < N; i++) {
            if (distance[i] == Integer.MAX_VALUE || distance[i] * 2 > X) {
                System.out.println(-1);
                return;
            }
            sum += (distance[i] * 2);
            if (sum > X) {
                sum = (distance[i] * 2);
                ans++;
                continue;
            }
        }

        System.out.println(ans);
    }

    static void bfs() {
        PriorityQueue<Node> pq = new PriorityQueue<>((n1, n2) -> n1.dist - n2.dist);
        pq.add(new Node(Y, 0));
        distance[Y] = 0;

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
