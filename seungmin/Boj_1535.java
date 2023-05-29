import java.io.*;
import java.util.*;

public class Boj_1535 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int[] dp = new int[101];
    static int[] L, J;
    static int N, ans;

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        L = new int[N + 1];
        J = new int[N + 1];

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            L[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            J[i] = Integer.parseInt(st.nextToken());
        }

        func(1, 0, 100);

        System.out.println(ans);
    }

    static void func(int k, int value, int health) {
        if (health < 1) {
            return;
        }
        if (k == N + 1) {
            ans = Math.max(ans, value);
            return;
        }
        func(k + 1, value + J[k], health - L[k]);
        func(k + 1, value, health);
    }
}
