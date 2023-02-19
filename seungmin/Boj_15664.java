import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Boj_15664 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static boolean[] isUsed;
    static int[] numbers, selected;
    static int N, M;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        isUsed = new boolean[N];
        numbers = new int[N];
        selected = new int[M];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(numbers);

        func(0);
        System.out.println(sb);
    }

    static void func(int k) {
        if (k == M) {
            for (int i = 0; i < M; i++) {
                sb.append(selected[i]).append(" ");
            }
            sb.append("\n");
            return;
        }

        int beforeUsed = 0;
        for (int i = k; i < N; i++) {
            if (beforeUsed == numbers[i] || isUsed[i]) {
                continue;
            }
            if (k > 0 && selected[k - 1] > numbers[i]) {
                continue;
            }
            selected[k] = numbers[i];
            beforeUsed = selected[k];
            isUsed[i] = true;
            func(k + 1);
            isUsed[i] = false;
            selected[k] = 0;
        }
    }
}
