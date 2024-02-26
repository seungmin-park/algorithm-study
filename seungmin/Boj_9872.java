import java.io.*;
import java.util.*;

public class Boj_9872 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static Map<String, Integer> group = new HashMap<>();
    static int N, ans = Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            List<String> temp = new ArrayList<>();
            while (st.hasMoreTokens()) {
                temp.add(st.nextToken());
            }
            temp.sort(String::compareTo);
            StringBuilder sb = new StringBuilder();
            for (String s : temp) {
                sb.append(s);
            }
            group.put(sb.toString(), group.getOrDefault(sb.toString(), 0) + 1);
            ans = Math.max(ans, group.get(sb.toString()));
        }

        System.out.println(ans);
    }
}
