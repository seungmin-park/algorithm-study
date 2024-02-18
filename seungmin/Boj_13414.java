import java.io.*;
import java.util.*;

public class Boj_13414 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static Set<String> l = new LinkedHashSet<>();
    static int K, N;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        K = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        for (int i = 1; i <= N; i++) {
            String studentCode = br.readLine();
            l.remove(studentCode);
            l.add(studentCode);
        }

        for (String s : l) {
            sb.append(s).append("\n");
            K--;
            if (K < 1) {
                break;
            }
        }


        System.out.println(sb);
    }
}
