import java.io.*;
import java.util.*;

public class Boj_14950 {
    static class City {
        int from, to, cost;

        City(int from, int to, int cost) {
            this.from = from;
            this.to = to;
            this.cost = cost;
        }
    }

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static List<City> cites = new ArrayList<>();
    static int[] parent;
    static int N, M, t, ans;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        t = Integer.parseInt(st.nextToken());

        parent = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            parent[i] = i;
        }

        for (int i = 1; i <= M; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            cites.add(new City(from, to, cost));
        }

        Collections.sort(cites, (c1, c2) -> c1.cost - c2.cost);
        for (City city : cites) {
            if (find(city.from) == find(city.to)) {
                continue;
            }
            union(city.from, city.to);
            ans += city.cost;
        }

        ans += t * (((N - 1) * (N - 2)) / 2);

        System.out.println(ans);
    }

    static int find(int target) {
        if (target == parent[target]) {
            return target;
        }

        return parent[target] = find(parent[target]);
    }

    static void union(int from, int to) {
        parent[find(to)] = find(from);
    }
}
