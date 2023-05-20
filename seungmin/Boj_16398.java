import java.io.*;
import java.util.*;

public class Boj_16398 {
    static class Planet {
        int from, to, cost;

        Planet(int from, int to, int cost) {
            this.from = from;
            this.to = to;
            this.cost = cost;
        }
    }

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static List<Planet> planets = new ArrayList<>();
    static int[] parent;
    static int N;
    static long ans;

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        parent = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            parent[i] = i;
        }

        for (int col = 1; col <= N; col++) {
            st = new StringTokenizer(br.readLine());
            for (int row = 1; row <= N; row++) {
                int cost = Integer.parseInt(st.nextToken());
                if (cost == 0) {
                    continue;
                }
                planets.add(new Planet(col, row, cost));
            }
        }

        Collections.sort(planets, (p1, p2) -> p1.cost - p2.cost);

        for (Planet planet : planets) {
            if (find(planet.from) == find(planet.to)) {
                continue;
            }

            union(planet.from, planet.to);
            ans += planet.cost;
        }

        System.out.println(ans);
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
