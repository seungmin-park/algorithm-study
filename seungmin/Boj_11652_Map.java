import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.TreeMap;

public class Boj_11652_Map {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static Map<Long, Integer> cards = new TreeMap<>();
    static long ans;
    static int N, cnt;

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            long card = Long.parseLong(br.readLine());
            if (!cards.containsKey(card)) {
                cards.put(card, 1);
                continue;
            }
            cards.put(card, cards.get(card) + 1);
        }

        for (Long card : cards.keySet()) {
            if (cnt < cards.get(card)) {
                ans = card;
                cnt = cards.get(card);
            }
        }

        System.out.println(ans);
    }
}
