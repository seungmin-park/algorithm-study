import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SWEA_1954 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static int[][] map;
    static int T, N;

    public static void main(String[] args) throws IOException {
        T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            N = Integer.parseInt(br.readLine());
            map = new int[N + 1][N + 1];
            int repeat = Math.round(N / (float) 2);
            fillArr(repeat);

            sb.append("#").append(t).append("\n");
            for (int i = 1; i <= N; i++) {
                for (int j = 1; j <= N; j++) {
                    sb.append(map[i][j]).append(" ");
                }
                sb.append("\n");
            }
        }

        System.out.println(sb);
    }

    private static void fillArr(int repeat) {
        for (int r = 1; r <= repeat; r++) {
            fillRight(r);
            fillDown(r);
            fillLeft(r);
            fillUp(r);
        }
    }

    private static void fillRight(int r) {
        for (int i = r; i <= N - r + 1; i++) {
            map[r][i] = map[r][i - 1] + 1;
        }
    }

    private static void fillDown(int r) {
        for (int i = r + 1; i <= N - r + 1; i++) {
            map[i][N - r + 1] = map[i - 1][N - r + 1] + 1;
        }
    }

    private static void fillLeft(int r) {
        for (int i = N - r; i >= r; i--) {
            map[N - r + 1][i] = map[N - r + 1][i + 1] + 1;
        }
    }

    private static void fillUp(int r) {
        for (int i = N - r; i > r; i--) {
            map[i][r] = map[i + 1][r] + 1;
        }
    }
}
