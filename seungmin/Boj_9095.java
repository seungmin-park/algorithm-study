import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Boj_9095 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static int T, N, ans;

    public static void main(String[] args) throws IOException {
        T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            ans = 0;
            N = Integer.parseInt(br.readLine());
            func(0);
            sb.append(ans).append("\n");
        }

        System.out.println(sb);
    }

    static void func(int k) {
        if (k == N) {
            ans++;
            return;
        }
        if (k > N) {
            return;
        }
        func(k + 1);
        func(k + 2);
        func(k + 3);
    }
}
