import java.io.*;
import java.util.*;

public class Boj_2161 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static int N;
    static Deque<Integer> dq = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        for (int i = 1; i <= N; i++) {
            dq.add(i);
        }

        for (int i = 1; dq.size() != 0; i++) {
            if (i % 2 == 0) {
                int now = dq.pollFirst();
                dq.addLast(now);
                continue;
            }
            sb.append(dq.pollFirst()).append(" ");
        }

        System.out.println(sb);
    }
}
