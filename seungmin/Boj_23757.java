import java.io.*;
import java.util.*;

public class Boj_23757 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
    static int N, M;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        for(int i = 1; i <= N; i++){
            pq.add(Integer.parseInt(st.nextToken()));
        }

        st = new StringTokenizer(br.readLine());
        for(int i = 1; i <= M; i++){
            int cnt = Integer.parseInt(st.nextToken());
            int now = pq.poll();
            if (now >= cnt) {
                pq.add(now - cnt);
            }else{
                System.out.println(0);
                return;
            }
        }

        System.out.println(1);
    }
}
