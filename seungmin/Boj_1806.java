import java.io.*;
import java.util.*;

public class Boj_1806 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int[] numbers;
    static int N, S, ans = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());
        numbers = new int[N + 1];

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }

        long sum = numbers[1];
        for (int L = 1, R = 1; L <= N; L++) {
            while (R < N && sum < S) {
                R++;
                sum += numbers[R];
            }
            if (sum >= S) {
                ans = Math.min(ans, R - L + 1);
                sum -= numbers[L];
            }
        }

        System.out.println(ans == Integer.MAX_VALUE ? 0 : ans);
    }
}
