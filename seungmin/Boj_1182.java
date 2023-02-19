import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_1182 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int[] numbers;
    static int N, S, ans;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());

        numbers = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }

        func(0, 0);
        System.out.println(S == 0 ? ans - 1 : ans);
    }

    static void func(int k, int value) {
        if (k == N) {
            if (value == S) {
                ans++;
            }
            return;
        }

        func(k + 1, value + numbers[k]);
        func(k + 1, value);
    }
}
