import java.io.*;
import java.util.*;

public class Boj_2167 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static int[][] map, sum;
    static int N, M, K;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N + 1][M + 1];
        sum = new int[N + 1][M + 1];

        for (int y = 1; y <= N; y++) {
            st = new StringTokenizer(br.readLine());
            for (int x = 1; x <= M; x++) {
                map[y][x] = Integer.parseInt(st.nextToken());
            }
        }

        for (int y = 1; y <= N; y++) {
            sum[y][1] = sum[y - 1][1] + map[y][1];
        }
        for (int x = 1; x <= M; x++) {
            sum[1][x] = sum[1][x - 1] + map[1][x];
        }

        for (int y = 1; y <= N; y++) {
            for (int x = 1; x <= M; x++) {
                sum[y][x] = map[y][x] + sum[y - 1][x] + sum[y][x - 1] - sum[y - 1][x - 1];
            }
        }

        K = Integer.parseInt(br.readLine());
        for (int k = 1; k <= K; k++) {
            st = new StringTokenizer(br.readLine());
            int startY = Integer.parseInt(st.nextToken());
            int startX = Integer.parseInt(st.nextToken());
            int endY = Integer.parseInt(st.nextToken());
            int endX = Integer.parseInt(st.nextToken());
            sb.append(sum[endY][endX] - sum[startY - 1][endX] - sum[endY][startX - 1] + sum[startY - 1][startX - 1]).append("\n");
        }
        System.out.println(sb);
    }
}
