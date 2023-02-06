import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_14888 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static int[] numbers;
    static int[] operators = new int[4];
    static int N;
    static int maxAns = Integer.MIN_VALUE;
    static int minAns = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        numbers = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 4; i++) {
            operators[i] = Integer.parseInt(st.nextToken());
        }

        func(1, numbers[0]);
        sb.append(maxAns).append("\n").append(minAns);
        System.out.println(sb);
    }

    static void func(int k, int result) {
        if (k == N) {
            maxAns = Math.max(result, maxAns);
            minAns = Math.min(result, minAns);
            return;
        }
        for (int i = 0; i < 4; i++) {
            if (operators[i] == 0) {
                continue;
            }
            if (i == 0) {
                operators[i]--;
                func(k + 1, result + numbers[k]);
                operators[i]++;
                continue;
            }
            if (i == 1) {
                operators[i]--;
                func(k + 1, result - numbers[k]);
                operators[i]++;
                continue;
            }
            if (i == 2) {
                operators[i]--;
                func(k + 1, result * numbers[k]);
                operators[i]++;
                continue;
            }
            operators[i]--;
            func(k + 1, result / numbers[k]);
            operators[i]++;
        }
    }
}
