import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Boj_1913 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static int[][] map;
    static int N, goal, goalY, goalX;

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        goal = Integer.parseInt(br.readLine());
        map = new int[N + 1][N + 1];

        int repeat = N / 2;
        map[0][1] = N * N + 1;

        for (int i = 1; i <= repeat + 1; i++) {
            for (int j = i; j <= N + 1 - i; j++) {
                map[j][i] = map[j - 1][i] - 1;
            }
            for (int j = i + 1; j <= N + 1 - i; j++) {
                map[N + 1 - i][j] = map[N + 1 - i][j - 1] - 1;
            }
            for (int j = N - i; j >= i; j--) {
                map[j][N + 1 - i] = map[j + 1][N + 1 - i] - 1;
            }

            for (int j = N - i; j > i; j--) {
                map[i][j] = map[i][j + 1] - 1;
            }
        }

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                if (map[i][j] == goal) {
                    goalY = i;
                    goalX = j;
                }
                sb.append(map[i][j]).append(" ");
            }
            sb.append("\n");
        }
        sb.append(goalY)
            .append(" ")
            .append(goalX);

        System.out.println(sb);
    }
}
