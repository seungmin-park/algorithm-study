import java.io.*;
import java.util.*;

public class Boj_13417 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static Deque<String> cards;
    static int T, N;

    public static void main(String[] args) throws IOException {
        T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            cards = new LinkedList<>();
            N = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());

            String now = st.nextToken();
            cards.offerFirst(now);

            for (int i = 1; i < N; i++) {
                String target = st.nextToken();
                if (now.compareTo(target) < 0) {
                    cards.offerLast(target);
                } else {
                    cards.offerFirst(target);
                }
                now = cards.peekFirst();
            }

            for (String card : cards) {
                sb.append(card);
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }
}
