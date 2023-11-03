import java.io.*;
import java.util.*;

public class Boj_11969 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static int[][] sum;
    static int[] arr;
    static int N, Q;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        Q = Integer.parseInt(st.nextToken());

        arr = new int[N + 1];
        sum = new int[N + 1][4];

        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            sum[i][1] = sum[i - 1][1];
            sum[i][2] = sum[i - 1][2];
            sum[i][3] = sum[i - 1][3];
            sum[i][arr[i]] = sum[i - 1][arr[i]] + 1;
        }

        for (int i = 1; i <= Q; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            for (int idx = 1; idx < 4; idx++) {
                sb.append(sum[to][idx] - sum[from][idx] + (arr[from] == idx ? 1 : 0)).append(" ");
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }
}
