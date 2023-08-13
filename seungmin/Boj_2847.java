import java.io.*;

public class Boj_2847 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int[] scores;
    static int N, ans;

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        scores = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            scores[i] = Integer.parseInt(br.readLine());
        }

        for (int i = N; i > 0; i--) {
            if (scores[i] <= scores[i - 1]) {
                int diff = scores[i - 1] - (scores[i] - 1);
                ans += diff;
                scores[i - 1] = scores[i] - 1;
            }
        }

        System.out.println(ans);
    }
}
