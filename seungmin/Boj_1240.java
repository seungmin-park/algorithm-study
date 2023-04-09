import java.io.*;
import java.util.*;

public class Boj_1240 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static int[] distance;
    static List<Node>[] tree;
    static int N, M;

    static class Node {
        int num, weight;

        Node(int num, int weight) {
            this.num = num;
            this.weight = weight;
        }
    }

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        tree = new ArrayList[N + 1];
        distance = new int[N + 1];

        for(int i =1; i <=N; i++){
            tree[i] = new ArrayList<>();
            distance[i] = Integer.MAX_VALUE;
        }

        for(int i = 1; i < N; i++){
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            tree[from].add(new Node(to, weight));
            tree[to].add(new Node(from, weight));
        }

        for (int i = 1; i <= M; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            bfs(from);
            sb.append(distance[to]).append("\n");
            Arrays.fill(distance, 1, N + 1, Integer.MAX_VALUE);
        }
        System.out.println(sb);
    }

    static void bfs(int start) {
        Queue<Node> q = new LinkedList<>();
        q.add(new Node(start, 0));
        distance[start] = 0;
        while (!q.isEmpty()) {
            Node now = q.poll();
            for (Node next : tree[now.num]) {
                if (distance[next.num] == Integer.MAX_VALUE) {
                    distance[next.num] = distance[now.num] + next.weight;
                    q.add(new Node(next.num, distance[next.num]));
                }
            }
        }
    }
}
