import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Boj_2748 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static long[] fibo;
    static int N;
    static long ans;

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        fibo = new long[N + 1];
        for (int i = 0; i < N + 1; i++) {
            fibo[i] = -1;
        }
        fibo[0] = 0;
        fibo[1] = 1;
        ans = func(N);

        System.out.println(ans);
    }

    static long func(int k) {
        if (fibo[k] == -1) {
            fibo[k] = func(k - 1) + func(k - 2);
        }

        return fibo[k];
    }
}
