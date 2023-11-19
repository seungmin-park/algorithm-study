import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_1859 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static long[] arr;
    static int T, N;

    public static void main(String[] args) throws IOException {
        T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            N = Integer.parseInt(br.readLine());
            arr = new long[N + 1];
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }
            long max = Long.MIN_VALUE;
            int sum = 0;
            long reserve = 0;
            long revenue = 0;
            for (int i = N - 1; i >= 0; i--) {
                if (arr[i] > max) {
                    revenue += (max * reserve) - sum;
                    max = arr[i];
                    sum = 0;
                    reserve = 0;
                } else {
                    sum += arr[i];
                    reserve++;
                }
            }
            revenue += (max * reserve) - sum;
            sb.append("#").append(t).append(" ").append(revenue).append("\n");
        }

        System.out.println(sb);
    }
}
