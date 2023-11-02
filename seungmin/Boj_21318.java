import java.io.*;
import java.util.*;

public class Boj_21318 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static int[] arr, sum;
    static int N, Q;

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        arr = new int[N + 1];
        sum = new int[N + 1];

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            if (arr[i] < arr[i - 1]) {
                sum[i] = sum[i - 1] + 1;
            }else{
                sum[i] = sum[i - 1];
            }
        }

        Q = Integer.parseInt(br.readLine());
        for (int i = 1; i <= Q; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            if (from == to) {
                sb.append(0).append("\n");
                continue;
            }
            int ans = sum[to] - sum[from];
            sb.append(ans).append("\n");
        }

        System.out.println(sb);
    }
}
