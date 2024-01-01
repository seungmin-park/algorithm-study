import java.io.*;
import java.util.*;

public class Boj_14235 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static PriorityQueue<Integer> gifts = new PriorityQueue<>(Comparator.reverseOrder());
    static int N;

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            int cnt = Integer.parseInt(st.nextToken());
            if (cnt == 0) {
                if (gifts.isEmpty()) {
                    sb.append(-1);
                } else {
                    sb.append(gifts.poll());
                }
                sb.append("\n");
                continue;
            }
            for (int c = 1; c <= cnt; c++) {
                gifts.add(Integer.parseInt(st.nextToken()));
            }
        }

        System.out.println(sb);
    }
}
