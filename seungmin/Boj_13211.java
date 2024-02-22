import java.io.*;
import java.util.*;

public class Boj_13211 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static Set<String> loss = new HashSet<>();
    static int N, M, ans;

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        for (int i = 1; i <= N; i++) {
            loss.add(br.readLine());
        }

        M = Integer.parseInt(br.readLine());
        for (int i = 1; i <= M; i++) {
            if (loss.contains(br.readLine())) {
                ans++;
            }
        }

        System.out.println(ans);
    }
}
