import java.io.*;
import java.util.*;

public class Boj_16507 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static int[][] arr, sum;
    static int R, C, Q;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        Q = Integer.parseInt(st.nextToken());

        arr = new int[R + 1][C + 1];
        sum = new int[R + 1][C + 1];

        for (int y = 1; y <= R; y++) {
            st = new StringTokenizer(br.readLine());
            for (int x = 1; x <= C; x++) {
                arr[y][x] = Integer.parseInt(st.nextToken());
            }
        }

        sum[1][1] = arr[1][1];
        for (int y = 1; y <= R; y++) {
            sum[y][1] = sum[y - 1][1] + arr[y][1];
        }
        for (int x = 1; x <= C; x++) {
            sum[1][x] = sum[1][x - 1] + arr[1][x];
        }

        for (int y = 1; y <= R; y++) {
            for (int x = 1; x <= C; x++) {
                sum[y][x] = arr[y][x] + sum[y - 1][x] + sum[y][x - 1] - sum[y - 1][x - 1];
            }
        }

        for (int q = 1; q <= Q; q++) {
            st = new StringTokenizer(br.readLine());
            int r1 = Integer.parseInt(st.nextToken());
            int c1 = Integer.parseInt(st.nextToken());
            int r2 = Integer.parseInt(st.nextToken());
            int c2 = Integer.parseInt(st.nextToken());
            int cnt = (r2 - r1 + 1) * (c2 - c1 + 1);
            int s = sum[r2][c2] - sum[r1 - 1][c2] - sum[r2][c1 - 1] + sum[r1 - 1][c1 - 1];
            sb.append(s / cnt).append("\n");
        }

        System.out.println(sb);
    }
}
