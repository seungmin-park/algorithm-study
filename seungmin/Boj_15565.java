import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_15565 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int[] dolls;
    static int N, K;
    static int ans = 1_000_001;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        dolls = new int[N + 1];

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            dolls[i] = Integer.parseInt(st.nextToken());
        }

        int cnt = 0;
        for (int L = 1, R = 0; L <= N; L++) {
            if (dolls[L] == 1) {
                while (R < N && cnt != K) {
                    R++;
                    if (dolls[R] == 1) {
                        cnt++;
                    }
                }
            }
            if (cnt == K) {
                ans = Math.min(ans, R - L + 1);
                cnt--;
            }
        }

        System.out.println(ans == 1_000_001 ? -1 : ans);
    }
}
