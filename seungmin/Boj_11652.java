import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * 입력의 최대 개수 100,000 -> int
 * 정수의 범위 -2^62 ~ 2^62 -> long
 * 1. 정렬 -> O(NlogN) -> 100,000 * 5
 * 2. 최빈 값 탐색 -> O(N) -> 100,000
 */
public class Boj_11652 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static long[] cards;
    static long ans;
    static int N, ansCnt;

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        if (N == 1) {
            System.out.println(br.readLine());
        }
        cards = new long[N];

        for (int i = 0; i < N; i++) {
            cards[i] = Long.parseLong(br.readLine());
        }

        Arrays.sort(cards);

        ans = cards[0];
        int cnt = 1;

        for (int i = 1; i < N; i++) {
            if (cards[i] != cards[i - 1]) {
                if (ansCnt < cnt) {
                    ans = cards[i - 1];
                    ansCnt = cnt;
                }
                cnt = 1;
                continue;
            }
            cnt++;
        }

        if (cards[N - 2] == cards[N - 1]) {
            if (ansCnt < cnt) {
                ans = cards[N - 1];
            }
        }

        System.out.println(ans);
    }
}
