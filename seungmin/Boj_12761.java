import java.io.*;
import java.util.*;

public class Boj_12761 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int[] dir, distance = new int[100_001];
    static int A, B, N, M;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        A = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        dir = new int[] { 1, -1, A, -A, B, -B, A, B };

        Arrays.fill(distance, -1);
        bfs();

        System.out.println(distance[M]);
    }

    static void bfs() {
        Queue<Integer> q = new LinkedList<>();
        q.add(N);
        distance[N] = 0;

        while (!q.isEmpty()) {
            int now = q.poll();
            for (int i = 0; i < 8; i++) {
                int next = 0;
                if (i > 5) {
                    next = now * dir[i];
                } else {
                    next = now + dir[i];
                }
                if (next < 0 || next > 100_000) {
                    continue;
                }
                if (distance[next] != -1) {
                    continue;
                }
                distance[next] = distance[now] + 1;
                q.add(next);
            }
        }
    }
}
