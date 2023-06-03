import java.io.*;
import java.util.*;

public class Boj_12865 {
    static class Bag {
        int weight, value;

        Bag(int weight, int value) {
            this.weight = weight;
            this.value = value;
        }
    }

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static List<Bag> bags = new ArrayList<>();
    static int[][] dp;
    static int N, K;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        dp = new int[N + 1][K + 1];

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            int weight = Integer.parseInt(st.nextToken());
            int value = Integer.parseInt(st.nextToken());
            bags.add(new Bag(weight, value));
        }

        Collections.sort(bags, (b1, b2) -> {
            if (b1.weight == b2.weight) {
                return b2.value - b1.value;
            }
            return b1.weight - b2.weight;
        });

        for (int i = 1; i <= N; i++) {
            Bag bag = bags.get(i - 1);
            for (int j = 1; j <= K; j++) {
                if (bag.weight <= j) {
                    dp[i][j] = Math.max(bag.value + dp[i - 1][j - bag.weight], dp[i - 1][j]);
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }

        System.out.println(dp[N][K]);
    }
}
