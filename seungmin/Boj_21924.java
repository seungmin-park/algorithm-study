import java.io.*;
import java.util.*;

public class Boj_21924 {
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
    static long max, ans;
    static int[] parent;
    static int N, M;

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
            int cost = Integer.parseInt(st.nextToken());
            cites.add(new City(from, to, cost));
            max += cost;
        }

        Collections.sort(cites, (c1, c2) -> c1.cost - c2.cost);

        for (City city : cites) {
            if (find(city.from) == find(city.to)) {
                continue;
            }

            union(city.from, city.to);
            ans += city.cost;
        }

        int cnt = 0;
        for (int i = 1; i <= N; i++) {
            if (i == parent[i]) {
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
