import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Boj_10974 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static boolean[] isUsed;
    static int[] selected;
    static int N;

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        selected = new int[N];
        isUsed = new boolean[N + 1];

        func(0);
        System.out.println(sb);
    }

    static void func(int k) {
        if (k == N) {
            for (int i = 0; i < N; i++) {
                sb.append(selected[i]).append(" ");
            }
            sb.append("\n");
            return;
        }

        for (int i = 1; i <= N; i++) {
            if (isUsed[i]) {
                continue;
            }
            selected[k] = i;
            isUsed[i] = true;
            func(k + 1);
            isUsed[i] = false;
        }
    }
}
