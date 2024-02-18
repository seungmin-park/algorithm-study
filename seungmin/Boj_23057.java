import java.io.*;
import java.util.*;

public class Boj_23057 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static Set<Integer> candidate = new HashSet<>();
    static int[] cards;
    static int N, M;

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());

        cards = new int[N];
        for (int i = 0; i < N; i++) {
            cards[i] = Integer.parseInt(st.nextToken());
            M += cards[i];
        }

        func(0, cards[0]);

        System.out.println(M - candidate.size() + 1);
    }

    static void func(int k, int sum) {
        candidate.add(sum);
        if (k == N) {
            return;
        }

        func(k + 1, sum + cards[k]);
        func(k + 1, sum);
    }
}
