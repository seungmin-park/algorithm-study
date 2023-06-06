import java.io.*;
import java.util.*;

/*
 * 틀린 이유: "고속도로 하나 하나는 다른 도시들을 거치지 않아야 하며" 조건 미충족
 */
public class Boj_14401 {
    static class Point {
        int x, y;

        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static class City {
        int from, to;
        double cost;

        City(int from, int to, double cost) {
            this.from = from;
            this.to = to;
            this.cost = cost;
        }
    }

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static List<Point> points = new ArrayList<>();
    static List<City> cites = new ArrayList<>();
    static boolean[][] over;
    static int[] parent;
    static int n, m;
    static long ans;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        parent = new int[n + 1];
        over = new boolean[n + 1][n + 1];
        for (int i = 1; i <= n; i++) {
            parent[i] = i;
        }

        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            points.add(new Point(x, y));
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    if (i == j || j == k || i == k) {
                        continue;
                    }
                    if ((Math.pow((points.get(i).x - points.get(j).x), 2)
                            + Math.pow((points.get(i).y - points.get(j).y), 2)) == Math
                                    .pow((points.get(k).x - points.get(j).x), 2)
                                    + Math.pow((points.get(k).x - points.get(j).x), 2)) {
                        if ((points.get(j).x - points.get(i).x) * (points.get(k).y - points.get(i).y)
                                - (points.get(k).x - points.get(i).x) * (points.get(j).y - points.get(i).y) == 0) {
                            over[i][k] = true;
                        }
                    }
                }
            }
        }

        for (int i = 1; i <= m; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            cites.add(new City(from, to, 0));
        }

        for (int i = 0; i < n - 1; i++) {
            Point from = points.get(i);
            for (int j = i + 1; j < n; j++) {
                if (over[i][j])
                    continue;
                Point to = points.get(j);
                double cost = Math.pow(Math.abs(from.x - to.x), 2) + Math.pow(Math.abs(from.y - to.y), 2);
                cites.add(new City(i + 1, j + 1, cost));
            }
        }

        Collections.sort(cites, (c1, c2) -> {
            if (c1.cost == 0 || c2.cost == 0) {
                return 1;
            }
            if (c2.cost > c1.cost) {
                return 1;
            }
            if (c2.cost < c1.cost) {
                return -1;
            }
            return 0;
        });

        for (City city : cites) {
            if (find(city.from) == find(city.to)) {
                continue;
            }

            union(city.from, city.to);
            ans += city.cost;
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
