import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Boj_2309 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static int[] A = new int[9];
    static int[] selected = new int[7];
    static int[] ans = new int[7];
    static boolean[] isUsed = new boolean[9];

    public static void main(String[] args) throws IOException {
        for (int i = 0; i < 9; i++) {
            A[i] = Integer.parseInt(br.readLine());
        }

        func(0, 0);
        Arrays.sort(ans);
        for (int i : ans) {
            sb.append(i).append("\n");
        }
        System.out.println(sb.toString());
    }

    static void func(int k, int value) {
        if (k == 7) {
            if (value == 100) {
                for (int i = 0; i < 7; i++) {
                    ans[i] = selected[i];
                }
            }
            return;
        }

        for (int i = k; i < 9; i++) {
            if (isUsed[i]) {
                continue;
            }
            selected[k] = A[i];
            isUsed[i] = true;
            func(k + 1, value + A[i]);
            selected[k] = 0;
            isUsed[i] = false;
        }
    }
}
