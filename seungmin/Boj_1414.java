import java.util.*;
import java.io.*;

public class Boj_1414 {
    static class Network {
        int from, to, len;

        Network(int from, int to, int len) {
            this.from = from;
            this.to = to;
            this.len = len;
        }
    }

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static List<Network> networks = new ArrayList<>();
    static int[] parent;
    static int N, max, ans;

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        parent = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            parent[i] = i;
            String lens = br.readLine();
            for (int j = 0; j < lens.length(); j++) {
                if (lens.charAt(j) == '0')
                    continue;
                if ('a' <= lens.charAt(j) && lens.charAt(j) <= 'z') {
                    networks.add(new Network(i, j + 1, lens.charAt(j) - 96));
                    max += lens.charAt(j) - 96;
                }
                if ('A' <= lens.charAt(j) && lens.charAt(j) <= 'Z') {
                    networks.add(new Network(i, j + 1, lens.charAt(j) - 38));
                    max += lens.charAt(j) - 38;
                }
            }
        }

        Collections.sort(networks, (n1, n2) -> n1.len - n2.len);

        for (Network network : networks) {
            if (find(network.from) == find(network.to)) {
                continue;
            }

            union(network.from, network.to);
            ans += network.len;
        }

        int cnt = 0;
        for (int i = 1; i <= N; i++) {
            if (parent[i] == i) {
                cnt++;
            }
            if (cnt > 1) {
                System.out.println(-1);
                return;
            }
        }

        System.out.println(max - ans);
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
