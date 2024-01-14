import java.io.*;
import java.util.*;

public class Boj_17264 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static Set<String> winning = new HashSet<>();
    static int N, P, W, L, G, score;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        P = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        W = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        G = Integer.parseInt(st.nextToken());

        for (int i = 1; i <= P; i++) {
            st = new StringTokenizer(br.readLine());
            String name = st.nextToken();
            String result = st.nextToken();
            if (result.equals("W")) {
                winning.add(name);
            }
        }

        for (int i = 1; i <= N; i++) {
            String name = br.readLine();
            if (winning.contains(name)) {
                score += W;
                if (score >= G) {
                    System.out.println("I AM NOT IRONMAN!!");
                    return;
                }
            } else {
                score = score - L <= 0 ? 0 : score - L;
            }
        }

        System.out.println("I AM IRONMAN!!");
    }
}
