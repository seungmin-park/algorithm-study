import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Boj_15666 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static int[] numbers, selected;
    static int N, M;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        numbers = new int[N + 1];
        selected = new int[M + 1];
        st = new StringTokenizer(br.readLine());

        for (int i = 1; i <= N; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(numbers);

        func(1);
        System.out.println(sb);
    }

    static void func(int k) {
        if (k == M + 1) {
            for (int i = 1; i <= M; i++) {
                sb.append(selected[i]).append(" ");
            }
            sb.append("\n");
            return;
        }

        int beforeUsedNumber = 0;
        for (int i = 1; i <= N; i++) {
            if (beforeUsedNumber == numbers[i]) {
                continue;
            }
            if (selected[k - 1] > numbers[i]) {
                continue;
            }
            beforeUsedNumber = numbers[i];
            selected[k] = beforeUsedNumber;
            func(k + 1);
        }
    }
}
