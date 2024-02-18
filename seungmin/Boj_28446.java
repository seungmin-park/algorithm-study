import java.io.*;
import java.util.*;

public class Boj_28446 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static Map<Integer, Integer> rocker = new HashMap<>();
    static int M;

    public static void main(String[] args) throws IOException {
        M = Integer.parseInt(br.readLine());
        for (int i = 1; i <= M; i++) {
            st = new StringTokenizer(br.readLine());
            String option = st.nextToken();
            if (option.equals("1")) {
                int number = Integer.parseInt(st.nextToken());
                int weight = Integer.parseInt(st.nextToken());
                rocker.put(weight, number);
            } else if (option.equals("2")) {
                int weight = Integer.parseInt(st.nextToken());
                sb.append(rocker.get(weight)).append("\n");
            }
        }

        System.out.println(sb);
    }
}
