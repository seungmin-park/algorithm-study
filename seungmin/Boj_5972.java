import java.io.*;
import java.util.*;

public class Boj_5972 {
    static class Node {
        int to, weight;

        Node(int to, int weight) {
            this.to = to;
            this.weight = weight;
        }
    }

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static List<Node>[] nodes;
    static int[] distance;
    static int N, M;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        nodes = new ArrayList[N + 1];
        distance = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            nodes[i] = new ArrayList<>();
            distance[i] = Integer.MAX_VALUE;
        }

        for (int i = 1; i <= M; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            nodes[from].add(new Node(to, weight));
            nodes[to].add(new Node(from, weight));
        }

        bfs();

        System.out.println(distance[N]);
    }

    static void bfs() {
        Queue<Node> q = new LinkedList<>();
        q.add(new Node(1, 0));
        distance[1] = 0;

        while (!q.isEmpty()) {
            Node now = q.poll();
            for (Node next : nodes[now.to]) {
                if (now.weight > distance[now.to]) {
                    continue;
                }
                if (distance[next.to] > distance[now.to] + next.weight) {
                    distance[next.to] = distance[now.to] + next.weight;
                    q.add(new Node(next.to, distance[next.to]));
                }
            }
        }
    }
}
