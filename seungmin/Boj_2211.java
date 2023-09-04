import java.io.*;
import java.util.*;

public class Boj_2211 {
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
    static int[] distance, dir;
    static int N, M, cnt;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        dir = new int[N + 1];
        distance = new int[N + 1];
        nodes = new ArrayList[N + 1];

        for (int i = 1; i <= N; i++) {
            distance[i] = Integer.MAX_VALUE;
            nodes[i] = new ArrayList<>();
        }

        for (int i = 1; i <= M; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int dist = Integer.parseInt(st.nextToken());
            nodes[from].add(new Node(to, dist));
            nodes[to].add(new Node(from, dist));
        }

        bfs();
        cnt = (int) Arrays.stream(dir)
                .filter(i -> i != 0)
                .count();
        sb.append(cnt).append("\n");
        for (int i = 1; i <= N; i++) {
            if (dir[i] == 0) {
                continue;
            }
            cnt++;
            sb.append(i).append(" ").append(dir[i]).append("\n");
        }

        System.out.println(sb);
    }

    static void bfs() {
        PriorityQueue<Node> pq = new PriorityQueue<>((n1, n2) -> n1.dist - n2.dist);
        pq.add(new Node(1, 0));
        distance[1] = 0;

        while (!pq.isEmpty()) {
            Node now = pq.poll();
            if (distance[now.to] < now.dist) {
                continue;
            }
            for (Node next : nodes[now.to]) {
                if (distance[next.to] > distance[now.to] + next.dist) {
                    distance[next.to] = distance[now.to] + next.dist;
                    dir[next.to] = now.to;
                    pq.add(new Node(next.to, distance[next.to]));
                }
            }
        }
    }
}
