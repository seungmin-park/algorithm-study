import java.io.*;
import java.util.*;

public class Boj_11101 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static Map<String, Integer> condition;
    static int T;

    public static void main(String[] args) throws IOException {
        T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            condition = new HashMap<>();
            st = new StringTokenizer(br.readLine(), ",");
            while (st.hasMoreTokens()) {
                String input = st.nextToken();
                String name = input.split(":")[0];
                int value = Integer.parseInt(input.split(":")[1]);
                condition.put(name, value);
            }

            st = new StringTokenizer(br.readLine(), "|");
            int ans = Integer.MAX_VALUE;
            while (st.hasMoreTokens()) {
                int time = -1;
                String[] conditions = st.nextToken().split("&");
                for (String cod : conditions) {
                    time = Math.max(time, condition.get(cod));
                }
                ans = Math.min(ans, time);
            }

            sb.append(ans).append("\n");
        }

        System.out.println(sb);
    }
}
