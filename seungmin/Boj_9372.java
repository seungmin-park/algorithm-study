import java.io.*;
import java.util.*;

public class Boj_9372 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static int T, N, M;

    public static void main(String[] args) throws IOException {
        T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());

            for (int i = 1; i <= M; i++) {
                br.readLine();
            }
            sb.append(N - 1).append("\n");
        }

        System.out.println(sb);
    }
}
