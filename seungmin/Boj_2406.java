import java.io.*;
import java.util.*;

public class Boj_2406 {
    static class Network {
        int from, to, cost;

        Network(int from, int to, int cost) {
            this.from = from;
            this.to = to;
            this.cost = cost;
        }
    }

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static List<Network> networks = new ArrayList<>();
    static Queue<Integer> linked = new LinkedList<>();
    static int[] parent;
    static int N, M, cost;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        parent = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            parent[i] = i;
        }

        for (int i = 1; i <= M; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            union(from, to);
        }

        br.readLine();
        for (int col = 2; col <= N; col++) {
            st = new StringTokenizer(br.readLine());
            st.nextToken();
            for (int row = 2; row <= N; row++) {
                int cost = Integer.parseInt(st.nextToken());
                if (cost == 0)
                    continue;
                networks.add(new Network(col, row, cost));
            }
        }

        Collections.sort(networks, (n1, n2) -> n1.cost - n2.cost);

        int conn = 0;
        for (Network network : networks) {
            if (find(network.from) == find(network.to)) {
                continue;
            }
            conn++;
            union(network.from, network.to);
            cost += network.cost;
            linked.add(network.to);
            linked.add(network.from);
        }
        sb.append(cost).append(" ").append(conn).append("\n");
        int cnt = 0;
        for (int num : linked) {
            sb.append(num);
            if (++cnt % 2 == 0) {
                sb.append("\n");
            } else {
                sb.append(" ");
            }
        }

        System.out.println(sb);
    }

    static int find(int num) {
        if (num == parent[num]) {
            return num;
        }

        return parent[num] = find(parent[num]);
    }

    static void union(int from, int to) {
        parent[find(to)] = find(from);
    }
}
