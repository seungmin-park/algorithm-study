import java.io.*;
import java.util.*;

public class Boj_9733 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static Map<String, Integer> behaviors = new HashMap<>();
    static String[] outputSequence = {"Re", "Pt", "Cc", "Ea", "Tb", "Cm", "Ex"};
    static String input;
    static int total;

    public static void main(String[] args) throws IOException {
        while ((input = br.readLine()) != null) {
            st = new StringTokenizer(input);
            while (st.hasMoreTokens()) {
                String behavior = st.nextToken();
                behaviors.put(behavior, behaviors.getOrDefault(behavior, 0) + 1);
                total++;
            }
        }

        for (String behavior : outputSequence) {
            Integer count = behaviors.getOrDefault(behavior, 0);
            sb.append(behavior).append(" ").append(count).append(" ").append(String.format("%.2f", count / (float) total)).append("\n");
        }
        sb.append("Total").append(" ").append(total).append(" ").append("1.00");

        System.out.println(sb);
    }
}
