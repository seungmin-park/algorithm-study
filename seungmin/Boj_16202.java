import java.io.*;
import java.util.*;

public class Boj_16202 {
    static class Node {
        int from, to, dist;

        Node(int from, int to, int dist) {
            this.from = from;
            this.to = to;
            this.dist = dist;
        }
    }

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static List<Node> nodes = new ArrayList<>();
    static int[] parents;
    static int N, M, K;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        parents = new int[N + 1];

        for (int i = 1; i <= M; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            nodes.add(new Node(from, to, i));
            nodes.add(new Node(to, from, i));
        }

        Collections.sort(nodes, (n1, n2) -> n1.dist - n2.dist);
        int score = -1;
        for (int t = 1; t <= K; t++) {
            if (score == 0) {
                sb.append(0).append(" ");
                continue;
            }
            for (int i = 1; i <= N; i++) {
                parents[i] = i;
            }

            int sum = 0;
            for (Node node : nodes) {
                if (find(node.from) == find(node.to)) {
                    continue;
                }

                sum += node.dist;
                union(node.from, node.to);
            }

            int cnt = 0;
            score = sum;
            for (int i = 1; i <= N; i++) {
                if (i == parents[i]) {
                    if (++cnt > 1) {
                        score = 0;
                        break;
                    }
                }
            }
            sb.append(score).append(" ");
            nodes.remove(0);
            nodes.remove(0);
        }
        System.out.println(sb);
    }

    static int find(int num) {
        if (parents[num] == num) {
            return num;
        }
        return parents[num] = find(parents[num]);
    }

    static void union(int from, int to) {
        int fromParent = find(from);
        int toParent = find(to);
        if (fromParent == toParent) {
            return;
        }
        parents[toParent] = fromParent;
    }
}
