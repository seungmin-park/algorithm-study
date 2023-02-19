import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Boj_15665 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static int[] numbers, selected;
    static int N, M;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

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

        int before = 0;
        for (int i = 0; i < N; i++) {
            if (before == numbers[i]) {
                continue;
            }
            before = numbers[i];
            selected[k] = before;
            func(k + 1);
        }
    }
}
