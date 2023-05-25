import java.io.*;
import java.util.*;

public class Boj_4386 {
    static class Star {
        double x, y;

        Star(double x, double y) {
            this.x = x;
            this.y = y;
        }
    }

    static class Matrix {
        Star from, to;
        double dist;

        Matrix(Star from, Star to, double dist) {
            this.from = from;
            this.to = to;
            this.dist = dist;
        }
    }

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static Map<Star, Star> parent = new HashMap<>();
    static List<Star> stars = new ArrayList<>();
    static List<Matrix> matrices = new ArrayList<>();
    static int N;
    static double ans;

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            double x = Double.parseDouble(st.nextToken());
            double y = Double.parseDouble(st.nextToken());
            Star star = new Star(x, y);
            stars.add(star);
            parent.put(star, star);
        }

        for (int i = 0; i < N - 1; i++) {
            Star from = stars.get(i);
            for (int j = i + 1; j < N; j++) {
                Star to = stars.get(j);
                double dist = Math.sqrt(Math.pow(to.x - from.x, 2) + Math.pow(to.y - from.y, 2));
                matrices.add(new Matrix(from, to, dist));
            }
        }

        Collections.sort(matrices, (m1, m2) -> (int) (m1.dist - m2.dist));

        for (Matrix matrix : matrices) {
            if (find(matrix.from).equals(find(matrix.to))) {
                continue;
            }

            union(matrix.from, matrix.to);
            ans += matrix.dist;
        }

        System.out.printf("%.2f", ans);
    }

    static Star find(Star star) {
        if (star.equals(parent.get(star))) {
            return star;
        }

        parent.put(star, find(parent.get(star)));
        return parent.get(star);
    }

    static void union(Star from, Star to) {
        parent.put(find(to), parent.get(find(from)));
    }
}
