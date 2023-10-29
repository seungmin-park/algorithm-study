import java.io.*;
import java.util.*;

public class Boj_15724 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static int[][] arr, sum;
    static int N, M, K;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[N + 1][M + 1];
        sum = new int[N + 1][M + 1];
        for (int y = 1; y <= N; y++) {
            st = new StringTokenizer(br.readLine());
            for (int x = 1; x <= M; x++) {
                arr[y][x] = Integer.parseInt(st.nextToken());
            }
        }

        for (int y = 1; y <= N; y++) {
            for (int x = 1; x <= M; x++) {
                sum[y][x] = sum[y - 1][x] + sum[y][x - 1] - sum[y - 1][x - 1] + arr[y][x];
            }
        }

        K = Integer.parseInt(br.readLine());
        for (int k = 1; k <= K; k++) {
            st = new StringTokenizer(br.readLine());
            int startY = Integer.parseInt(st.nextToken());
            int startX = Integer.parseInt(st.nextToken());
            int endY = Integer.parseInt(st.nextToken());
            int endX = Integer.parseInt(st.nextToken());
            sb.append(sum[endY][endX] - sum[startY - 1][endX] - sum[endY][startX - 1] + sum[startY - 1][startX - 1])
                    .append("\n");
        }

        System.out.println(sb);
    }
}
