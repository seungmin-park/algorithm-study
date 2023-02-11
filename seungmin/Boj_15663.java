import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Boj_15663 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb;
    static StringTokenizer st;
    static Set<String> ans = new LinkedHashSet<>();
    static int[] numbers, selected;
    static boolean[] isUsed;
    static int N, M;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        selected = new int[M];

        numbers = new int[N];
        isUsed = new boolean[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }

        func(0);
        ans.forEach(System.out::println);
    }

    static void func(int k) {
        sb = new StringBuilder();
        if (k == M) {
            for (int i = 0; i < M; i++) {
                sb.append(selected[i]).append(" ");
            }
            ans.add(sb.toString());
            return;
        }

        for (int i = 0; i < N; i++) {
            if (isUsed[i]) {
                continue;
            }
            selected[k] = numbers[i];
            isUsed[i] = true;
            func(k + 1);
            isUsed[i] = false;
        }
    }
}
