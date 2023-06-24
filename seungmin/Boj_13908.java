import java.io.*;
import java.util.*;

/**
 * 틀린 이유: 'm이 0인 경우 둘째 줄은 주어지지 않는다.' 조건 미 충족
 */
public class Boj_13908 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static List<Integer> cands = new ArrayList<>();
    static int[] numbers = new int[10];
    static int n, m, ans;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        if (m > 0) {
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < m; i++) {
                cands.add(Integer.parseInt(st.nextToken()));
            }
        }

        func(0);

        System.out.println(ans);
    }

    static void func(int k) {
        if (k == n) {
            for (int cand : cands) {
                if (numbers[cand] < 1) {
                    return;
                }
            }
            ans++;
            return;
        }

        for (int i = 0; i < 10; i++) {
            numbers[i]++;
            func(k + 1);
            numbers[i]--;
        }
    }
}
