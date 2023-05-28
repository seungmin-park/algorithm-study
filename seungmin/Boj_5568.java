import java.io.*;
import java.util.*;

public class Boj_5568 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static Set<String> ans = new HashSet<>();
    static boolean[] isUsed;
    static int[] numbers, cand;
    static int n, k;

    public static void main(String[] args) throws IOException {
        n = Integer.parseInt(br.readLine());
        k = Integer.parseInt(br.readLine());
        isUsed = new boolean[n + 1];
        numbers = new int[n + 1];
        cand = new int[k + 1];

        for (int i = 1; i <= n; i++) {
            numbers[i] = Integer.parseInt(br.readLine());
        }

        func(0);
        System.out.println(ans.size());
    }

    static void func(int depth) {
        if (k == depth) {
            StringBuilder sb = new StringBuilder();
            for (int i = 1; i <= k; i++) {
                sb.append(cand[i]);
            }
            ans.add(sb.toString());
            return;
        }

        for (int i = 1; i <= n; i++) {
            if (isUsed[i])
                continue;
            isUsed[i] = true;
            cand[depth + 1] = numbers[i];
            func(depth + 1);
            cand[depth + 1] = 0;
            isUsed[i] = false;
        }
    }
}
