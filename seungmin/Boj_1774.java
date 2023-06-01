import java.io.*;
import java.util.*;

public class Boj_1774 {
    static class Star {
        int x, y;

        Star(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static class Matrix {
        int from, to;
        double dist;

        Matrix(int from, int to, double dist) {
            this.from = from;
            this.to = to;
            this.dist = dist;
        }
    }

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static Star[] stars;
    static List<Matrix> matrixs = new ArrayList<>();
    static double ans;
    static int[] parent;
    static int N, M;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        parent = new int[N + 1];
        stars = new Star[N + 1];

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            stars[i] = new Star(x, y);
            parent[i] = i;
        }

        for (int i = 1; i < N; i++) {
            for (int j = i + 1; j <= N; j++) {
                Star from = stars[i];
                Star to = stars[j];
                int fromX = from.x;
                int fromY = from.y;
                int toX = to.x;
                int toY = to.y;
                double dist = Math
                        .sqrt(Math.pow(Math.abs(fromX - toX), 2) + Math.pow(Math.abs(Math.abs(fromY - toY)), 2));
                matrixs.add(new Matrix(i, j, dist));
            }
        }

        for (int i = 1; i <= M; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            matrixs.add(new Matrix(from, to, 0));
        }

        Collections.sort(matrixs, (m1, m2) -> {
            if (m1.dist > m2.dist) {
                return 1;
            }
            if (m1.dist == m2.dist) {
                return 0;
            }
            return -1;
        });

        for (Matrix matrix : matrixs) {
            if (find(matrix.from) == find(matrix.to)) {
                continue;
            }

            union(matrix.from, matrix.to);
            ans += matrix.dist;
        }

        System.out.printf("%.2f", ans);
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
