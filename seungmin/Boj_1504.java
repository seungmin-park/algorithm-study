import java.io.*;
import java.util.*;

public class Boj_1504 {
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
    static Map<Integer, int[]> distance;
    static int N, E, ans;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());

        graph = new ArrayList[N + 1];
        distance = new HashMap<>();
        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 1; i <= E; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            graph[from].add(new Node(to, weight));
            graph[to].add(new Node(from, weight));
        }

        st = new StringTokenizer(br.readLine());
        int u = Integer.parseInt(st.nextToken());
        int v = Integer.parseInt(st.nextToken());
        distance.put(1, new int[N + 1]);
        distance.put(u, new int[N + 1]);
        distance.put(v, new int[N + 1]);
        for (int key : distance.keySet()) {
            for (int i = 1; i <= N; i++) {
                distance.get(key)[i] = Integer.MAX_VALUE;
            }
        }

        for (int key : distance.keySet()) {
            bfs(key);
        }
        int cand1 = getCandidateDistance(1, u, v, N, distance);
        int cand2 = getCandidateDistance(1, v, u, N, distance);

        if (cand1 == Integer.MAX_VALUE && cand2 == Integer.MAX_VALUE) {
            System.out.println(-1);
            return;
        }

        System.out.println(Math.min(cand1, cand2));
    }

    private static void bfs(int start) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(start, 0));
        distance.get(start)[start] = 0;

        while (!pq.isEmpty()) {
            Node now = pq.poll();
            if (distance.get(start)[now.num] < now.weight)
                continue;
            for (Node next : graph[now.num]) {
                if (distance.get(start)[next.num] > distance.get(start)[now.num] + next.weight) {
                    distance.get(start)[next.num] = distance.get(start)[now.num] + next.weight;
                    pq.add(new Node(next.num, distance.get(start)[next.num]));
                }
            }
        }
    }

    private static int getCandidateDistance(int start, int mid, int end, int dest, Map<Integer, int[]> distance2) {
        if (distance2.get(start)[mid] != Integer.MAX_VALUE && distance2.get(mid)[end] != Integer.MAX_VALUE
                && distance2.get(end)[dest] != Integer.MAX_VALUE) {
            return distance2.get(start)[mid] + distance2.get(mid)[end] + distance2.get(end)[dest];
        } else {
            return Integer.MAX_VALUE;
        }
    }

}
