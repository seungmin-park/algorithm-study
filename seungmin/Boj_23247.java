import java.io.*;
import java.util.*;

public class Boj_23247 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int[][] matrix, sum;
    static int n, m, ans;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        matrix = new int[n + 1][m + 1];
        sum = new int[n + 1][m + 1];

        for (int y = 1; y <= n; y++) {
            st = new StringTokenizer(br.readLine());
            for (int x = 1; x <= m; x++) {
                matrix[y][x] = Integer.parseInt(st.nextToken());
            }
        }

        sum[1][1] = matrix[1][1];
        for (int i = 1; i <= n; i++) {
            sum[i][1] = sum[i - 1][1] + matrix[i][1];
        }

        for (int i = 1; i <= m; i++) {
            sum[1][i] = sum[1][i - 1] + matrix[1][i];
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                sum[i][j] = matrix[i][j] + sum[i - 1][j] + sum[i][j - 1] - sum[i - 1][j - 1];
            }
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                for (int k = i; k <= n; k++) {
                    for (int l = j; l <= m; l++) {
                        int cand = sum[k][l] - sum[i - 1][l] - sum[k][j - 1] + sum[i - 1][j - 1];
                        if (cand == 10)
                            ans++;
                        if (cand >= 10)
                            break;
                    }
                }
            }
        }

        System.out.println(ans);
    }
}
