import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Boj_16472 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static String str;
    static int[] alphabets = new int[26];
    static int N;
    static int ans = -1;

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        str = br.readLine();

        int cnt = 0;
        for (int L = 0, R = -1; L < str.length() - 1; L++) {
            while (R < str.length() - 1 && cnt <= N) {
                R++;
                alphabets[str.charAt(R) - 97]++;
                cnt = (int) Arrays.stream(alphabets)
                        .filter(a -> a > 0)
                        .count();
                if (cnt <= N) {
                    ans = Math.max(ans, R - L + 1);
                }
                if (cnt > N) {
                    break;
                }
            }
            alphabets[str.charAt(L) - 97]--;
            cnt = (int) Arrays.stream(alphabets)
                    .filter(a -> a > 0)
                    .count();
        }
        System.out.println(ans);
    }
}
