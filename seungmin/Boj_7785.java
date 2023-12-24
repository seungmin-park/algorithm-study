import java.io.*;
import java.util.*;

public class Boj_7785 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static Set<String> s = new HashSet<>();
    static int N;

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            String person = st.nextToken();
            String option = st.nextToken();
            if (option.equals("enter")) {
                s.add(person);
                continue;
            }
            s.remove(person);
        }

        s.stream()
                .sorted(Comparator.reverseOrder())
                .forEach(p -> sb.append(p).append("\n"));

        System.out.println(sb);
    }
}
