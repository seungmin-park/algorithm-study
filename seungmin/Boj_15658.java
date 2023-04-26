import java.io.*;
import java.util.*;

public class Boj_15658 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static int[] opers = new int[4];
    static int[] numbers;
    static int N, M, max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;

    public static void main(String[] argss) throws IOException {
        N = Integer.parseInt(br.readLine());
        numbers = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 4; i++) {
            opers[i] = Integer.parseInt(st.nextToken());
        }

        func(1, numbers[0]);
        sb.append(max).append("\n").append(min);

        System.out.println(sb);
    }

    static void func(int k, int value) {
        if (k == N) {
            max = Math.max(max, value);
            min = Math.min(min, value);
            return;
        }

        if (opers[0] != 0) {
            opers[0]--;
            func(k + 1, value + numbers[k]);
            opers[0]++;
        }
        if (opers[1] != 0) {
            opers[1]--;
            func(k + 1, value - numbers[k]);
            opers[1]++;
        }
        if (opers[2] != 0) {
            opers[2]--;
            func(k + 1, value * numbers[k]);
            opers[2]++;
        }
        if (opers[3] != 0) {
            opers[3]--;
            func(k + 1, value / numbers[k]);
            opers[3]++;
        }
    }
}
