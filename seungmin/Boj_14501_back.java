import java.io.*;
import java.util.*;

public class Boj_14501_back {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int[] T, P;
    static int N, ans = Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        T = new int[N + 1];
        P = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            T[i] = Integer.parseInt(st.nextToken());
            P[i] = Integer.parseInt(st.nextToken());
        }

        func(1, 0);
        System.out.println(ans);
    }

    static void func(int k, int value) {
        if (k > N) {
            ans = Math.max(ans, value);
            return;
        }

        if (k + T[k] <= N + 1) {
            func(k + T[k], value + P[k]);
        }
        func(k + 1, value);

    }
}
