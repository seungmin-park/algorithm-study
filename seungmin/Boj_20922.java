import java.io.*;
import java.util.*;

public class Boj_20922 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int[] check = new int[200_001];
    static int[] numbers;
    static int N, K, ans;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        numbers = new int[N + 2];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }

        for (int L = 1, R = 0; L <= N; L++) {
            while (R < N && check[numbers[R]] <= K) {
                R++;
                check[numbers[R]]++;
            }
            ans = Math.max(ans, R - L);
            check[numbers[L]]--;
        }

        for (int R = N, L = N + 1; R > 0; R--) {
            while (L > 0 && check[numbers[L]] <= K) {
                L--;
                check[numbers[L]]++;
            }
            ans = Math.max(ans, R - L);
            check[numbers[R]]--;
        }

        System.out.println(ans);
    }
}
