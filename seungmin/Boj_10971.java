import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_10971 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static boolean[] visit;
    static int[][] W;
    static int N, ans = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        W = new int[N + 1][N + 1];
        visit = new boolean[N + 1];

        for (int row = 1; row <= N; row++) {
            st = new StringTokenizer(br.readLine());
            for (int col = 1; col <= N; col++) {
                W[row][col] = Integer.parseInt(st.nextToken());
            }
        }
        visit[1] = true;
        func(1, 1, 0);
        System.out.println(ans);
    }

    static void func(int k, int row, int degree) {
        if (k == N) {
            if (W[row][1] != 0) {
                degree += W[row][1];
                ans = Math.min(ans, degree);
            }
            return;
        }

        for (int col = 1; col <= N; col++) {
            if (visit[col] || W[row][col] == 0) {
                continue;
            }
            visit[col] = true;
            func(k + 1, col, degree + W[row][col]);
            visit[col] = false;
        }
    }
}
