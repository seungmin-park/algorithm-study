import java.io.*;
import java.util.*;

public class Boj_1446 {
    static class Node {
        int to, dist;

        Node(int to, int dist) {
            this.to = to;
            this.dist = dist;
        }
    }

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static List<Node>[] nodes;
    static int[] distances = new int[10_001];
    static int N, D;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        D = Integer.parseInt(st.nextToken());

        nodes = new ArrayList[10_001];
        for (int i = 0; i <= 10_000; i++) {
            distances[i] = 123_456_789;
            nodes[i] = new ArrayList<>();
        }

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int dist = Integer.parseInt(st.nextToken());
            nodes[from].add(new Node(to, dist));
        }

        distances[0] = 0;
        for (int i = 0; i < D; i++) {
            for (Node next : nodes[i]) {
                if (distances[next.to] > next.dist + distances[i]) {
                    distances[next.to] = next.dist + distances[i];
                }
            }
            distances[i + 1] = Math.min(distances[i + 1], distances[i] + 1);
        }

        System.out.println(distances[D]);
    }
}
