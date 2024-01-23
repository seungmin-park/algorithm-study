import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class Boj_20303 {
    static class Pair {
        int cry, candy;

        public Pair(int cry, int candy) {
            this.cry = cry;
            this.candy = candy;
        }
    }

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static Map<Integer, Pair> pairs = new HashMap<>();
    static StringTokenizer st;
    static int[][] dp;
    static int[] parents, candies;
    static int N, M, K;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        parents = new int[N + 1];
        candies = new int[N + 1];
        dp = new int[2][K];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            parents[i] = i;
            candies[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 1; i <= M; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            if (find(from) == find(to)) {
                continue;
            }

            union(from, to);
        }

        for (int i = 1; i <= N; i++) {
            int parent = find(i);
            if (!pairs.containsKey(parent)) {
                pairs.put(parent, new Pair(0, 0));
            }
            Pair pair = pairs.get(parent);
            pair.cry++;
            pair.candy += candies[i];
        }

        List<Pair> list = pairs.keySet()
                .stream()
                .filter(key -> pairs.get(key).cry < K)
                .map(pairs::get)
                .collect(Collectors.toList());

        for (Pair pair : list) {
            for (int i = 0; i < K; i++) {
                if (i >= pair.cry) {
                    dp[1][i] = Math.max(dp[0][i], dp[0][i - pair.cry] + pair.candy);
                } else {
                    dp[1][i] = dp[0][i];
                }
            }

            for (int i = 0; i < K; i++) {
                dp[0][i] = dp[1][i];
            }
        }

        System.out.println(dp[1][K - 1]);
    }

    static int find(int num) {
        if (num == parents[num]) {
            return parents[num];
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
