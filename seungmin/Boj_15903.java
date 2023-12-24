import java.io.*;
import java.util.*;

public class Boj_15903 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static PriorityQueue<Long> pq = new PriorityQueue<>();
    static long ans;
    static int N, M;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            pq.add(Long.parseLong(st.nextToken()));
        }

        for (int i = 1; i <= M; i++) {
            long x = pq.poll();
            long y = pq.poll();
            pq.add(x + y);
            pq.add(x + y);
        }

        for (long number : pq) {
            ans += number;
        }

        System.out.println(ans);
    }
}
