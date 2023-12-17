import java.io.*;
import java.util.*;

public class Boj_26069 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static Set<String> s = new HashSet<>();
    static String target = "ChongChong";
    static int N;

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            String from = st.nextToken();
            String to = st.nextToken();
            if (from.equals(target) || to.equals(target)) {
                s.add(from);
                s.add(to);
                continue;
            }

            if (s.contains(from) || s.contains(to)) {
                s.add(from);
                s.add(to);
            }
        }


        System.out.println(s.size());
    }
}
