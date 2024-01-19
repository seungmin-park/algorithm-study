import java.io.*;
import java.util.*;

public class Boj_1715 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static PriorityQueue<Integer> pq = new PriorityQueue<>();
    static int N, ans;

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        for (int i = 1; i <= N; i++) {
            pq.add(Integer.parseInt(br.readLine()));
        }

        while (pq.size() > 1) {
            int left = pq.poll();
            int right = pq.poll();
            int sum = left + right;
            ans += sum;
            pq.add(sum);
        }

        System.out.println(ans);
    }
}
