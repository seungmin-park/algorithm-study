import java.io.*;
import java.util.*;

public class Boj_16953 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int A, B;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        A = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());

        System.out.println(bfs());
    }

    static int bfs() {
        Queue<Long> q = new LinkedList<>();
        q.add((long) A);
        int cnt = 0;

        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                long now = q.poll();
                if (now == B) {
                    return cnt + 1;
                }
                if (now * 2 <= B) {
                    q.add(now * 2);
                }
                if (now * 10 + 1 <= B) {
                    q.add(now * 10 + 1);
                }
            }
            cnt++;
        }

        return -1;
    }
}
