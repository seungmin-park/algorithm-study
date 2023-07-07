import java.io.*;
import java.util.*;

public class Boj_1613 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static int[][] histories;
    static int n, k, s;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        histories = new int[n + 1][n + 1];

        for (int col = 1; col <= n; col++) {
            for (int row = 1; row <= n; row++) {
                histories[col][row] = Integer.MAX_VALUE;
            }
        }

        for (int i = 1; i <= k; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            histories[from][to] = 1;
        }

        for (int c = 1; c <= n; c++) {
            for (int a = 1; a <= n; a++) {
                for (int b = 1; b <= n; b++) {
                    if (c == a || c == b || a == b) {
                        continue;
                    }
                    if (histories[a][c] == Integer.MAX_VALUE || histories[c][b] == Integer.MAX_VALUE) {
                        continue;
                    }

                    histories[a][b] = Math.min(histories[a][b], histories[a][c] + histories[c][b]);
                }
            }
        }

        s = Integer.parseInt(br.readLine());
        for (int i = 1; i <= s; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            if (histories[from][to] == Integer.MAX_VALUE) {
                if (histories[to][from] == Integer.MAX_VALUE) {
                    sb.append(0).append("\n");
                } else {
                    sb.append(1).append("\n");
                }
            } else {
                sb.append(-1).append("\n");
            }
        }

        System.out.println(sb);
    }
}
