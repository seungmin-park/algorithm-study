import java.io.*;
import java.util.*;

public class Boj_4158 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static Set<Integer> own;
    static int N, M;

    public static void main(String[] args) throws IOException {
        while ((st = new StringTokenizer(br.readLine())).hasMoreTokens()) {
            int ans = 0;
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            if (N == 0 && M == 0) {
                break;
            }
            own = new HashSet<>();
            for (int i = 1; i <= N; i++) {
                own.add(Integer.parseInt(br.readLine()));
            }

            for (int i = 1; i <= M; i++) {
                int num = Integer.parseInt(br.readLine());
                if (own.contains(num)) {
                    ans++;
                }
            }
            sb.append(ans).append("\n");
        }

        System.out.println(sb);
    }
}
