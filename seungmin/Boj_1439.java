import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Boj_1439 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static String S;
    static int zeroCnt, oneCnt;

    public static void main(String[] args) throws IOException {
        S = br.readLine();
        for (int i = 0; i < S.length() - 1; i++) {
            if (S.charAt(i) != S.charAt(i + 1)) {
                if (S.charAt(i) == 48) {
                    zeroCnt++;
                    continue;
                }
                oneCnt++;
            }
        }
        // 마지막 중복 체크
        if (S.charAt(S.length() - 1) == 48) {
            zeroCnt++;
        } else {
            oneCnt++;
        }

        System.out.println(Math.min(zeroCnt, oneCnt));
    }
}
