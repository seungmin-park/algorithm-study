import java.io.*;
import java.util.*;

public class Boj_9375 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static Map<String, Integer> cloth = new HashMap<>();
    static StringTokenizer st;
    static int T, N;

    public static void main(String[] args) throws IOException {
        T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            int ans = 1;
            N = Integer.parseInt(br.readLine());
            cloth = new HashMap<>();
            for (int i = 1; i <= N; i++) {
                st = new StringTokenizer(br.readLine());
                String spec = st.nextToken();
                String kind = st.nextToken();
                cloth.put(kind, cloth.getOrDefault(kind, 0) + 1);
            }

            for (Integer value : cloth.values()) {
                ans *= value + 1;
            }

            sb.append(ans - 1).append("\n");
        }

        System.out.println(sb);
    }
}
