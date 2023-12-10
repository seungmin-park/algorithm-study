import java.io.*;
import java.util.*;

public class Boj_1822 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static Set<Integer> A = new TreeSet<>();
    static Set<Integer> B = new TreeSet<>();
    static int N, M;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            int now = Integer.parseInt(st.nextToken());
            A.add(now);
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= M; i++) {
            int now = Integer.parseInt(st.nextToken());
            B.add(now);
        }

        for (Integer b : B) {
            A.remove(b);
        }

        sb.append(A.size()).append("\n");
        for (Integer a : A) {
            sb.append(a).append(" ");
        }

        System.out.println(sb);
    }
}
