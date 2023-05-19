import java.io.*;
import java.util.*;

public class Boj_6497 {
    static class House {
        int from, to, cost;

        House(int from, int to, int cost) {
            this.from = from;
            this.to = to;
            this.cost = cost;
        }
    }

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static List<House> houses;
    static int[] parent;
    static int m, n;

    public static void main(String[] args) throws IOException {
        while (true) {
            st = new StringTokenizer(br.readLine());
            m = Integer.parseInt(st.nextToken());
            n = Integer.parseInt(st.nextToken());
            if (m == 0 && n == 0) {
                break;
            }
            int after = 0;
            int before = 0;
            houses = new ArrayList<>();
            parent = new int[m];
            for (int i = 0; i < m; i++) {
                parent[i] = i;
            }

            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());
                int from = Integer.parseInt(st.nextToken());
                int to = Integer.parseInt(st.nextToken());
                int cost = Integer.parseInt(st.nextToken());
                houses.add(new House(from, to, cost));
            }

            Collections.sort(houses, (h1, h2) -> h1.cost - h2.cost);

            for (House house : houses) {
                after += house.cost;
                if (find(house.from) == find(house.to)) {
                    continue;
                }

                union(house.from, house.to);
                before += house.cost;
            }
            sb.append(after - before).append("\n");
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
