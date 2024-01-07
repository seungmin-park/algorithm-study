import java.io.*;
import java.util.*;

public class Boj_19683 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
    static int N, M, H;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        for(int i = 1 ; i <= N; i++){
            pq.add(Integer.parseInt(br.readLine()));
        }

        for(int i = 0; i <= M; i++){
            int target = pq.peek();
            if (target < H) {
                sb.append("YES").append("\n").append(i);
                System.out.println(sb);
                return;
            }
            if (i == M) {
                break;
            }
            target = pq.poll();
            target /= 2;
            if (target < 1) {
                target = 1;
            }
            pq.add(target);
        }

        sb.append("NO").append("\n").append(pq.poll());
        System.out.println(sb);
    }
}
