import java.io.*;
import java.util.*;

public class Boj_11286 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static PriorityQueue<Integer> pq = new PriorityQueue<>((i1, i2) -> {
        if (Math.abs(i1) == Math.abs(i2)) {
            return i1 - i2;
        }
        return Math.abs(i1) - Math.abs(i2);
    });
    static int N;

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        for (int i = 1; i <= N; i++) {
            int curr = Integer.parseInt(br.readLine());
            if (curr == 0) {
                if (pq.size() == 0) {
                    sb.append(0).append("\n");
                } else {
                    sb.append(pq.poll()).append("\n");
                }
            } else {
                pq.add(curr);
            }
        }

        System.out.println(sb);
    }
}
