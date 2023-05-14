import java.io.*;
import java.util.*;

public class Boj_14284 {
    static class Node implements Comparable<Node> {
        int num, weight;

        Node(int num, int weight) {
            this.num = num;
            this.weight = weight;
        }

        @Override
        public int compareTo(Node n) {
            return this.weight - n.weight;
        }
    }

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static List<Node>[] graph;
    static int[] distance;
    static int N, M, s, t;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        distance = new int[N + 1];
        graph = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
            distance[i] = Integer.MAX_VALUE;
        }

        for (int i = 1; i <= M; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            graph[from].add(new Node(to, weight));
            graph[to].add(new Node(from, weight));
        }

        st = new StringTokenizer(br.readLine());
        s = Integer.parseInt(st.nextToken());
        t = Integer.parseInt(st.nextToken());
        bfs();

        System.out.println(distance[t]);
    }

    static void bfs() {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(s, 0));
        distance[s] = 0;

        while (!pq.isEmpty()) {
            Node now = pq.poll();
            if (distance[now.num] < now.weight)
                continue;
            for (Node next : graph[now.num]) {
                if (distance[next.num] > distance[now.num] + next.weight) {
                    distance[next.num] = distance[now.num] + next.weight;
                    pq.add(new Node(next.num, distance[next.num]));
                }
            }
        }
    }
}
