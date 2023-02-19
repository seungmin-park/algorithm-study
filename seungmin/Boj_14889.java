import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_14889 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int[][] startLink;
    static boolean[] isUsed;
    static int N;
    static int ans = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());

        startLink = new int[N + 1][N + 1];
        isUsed = new boolean[N + 1];

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                startLink[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        func(1, N / 2);

        System.out.println(ans);
    }

    static void func(int k, int cnt) {
        if (cnt == 0) {
            int start = 0;
            int link = 0;
            for (int i = 1; i <= N - 1; i++) {
                for (int j = i + 1; j <= N; j++) {
                    if (isUsed[i] && isUsed[j]) {
                        start += startLink[i][j];
                        start += startLink[j][i];
                        continue;
                    }
                    if (!isUsed[i] && !isUsed[j]) {
                        link += startLink[i][j];
                        link += startLink[j][i];
                    }
                }
            }

            ans = Math.min(ans, Math.abs(start - link));
            if (ans == 0) {
                System.out.println(0);
                System.exit(0);
            }
            return;
        }

        for (int i = k; i <= N; i++) {
            isUsed[i] = true;
            func(i + 1, cnt - 1);
            isUsed[i] = false;
        }
    }
}
