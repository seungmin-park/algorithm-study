import java.io.*;
import java.util.*;

public class Boj_10867 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static Set<Integer> h = new TreeSet<>();
    static int N;

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            h.add(Integer.parseInt(st.nextToken()));
        }

        for (int e : h) {
            sb.append(e).append(" ");
        }

        System.out.println(sb);
    }
}
