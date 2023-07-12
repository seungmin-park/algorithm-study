import java.io.*;
import java.util.*;

public class Boj_14248 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static boolean[] visited;
    static int[] bridge;
    static int N, start, ans;

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        bridge = new int[N + 1];
        visited = new boolean[N + 1];

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            bridge[i] = Integer.parseInt(st.nextToken());
        }
        start = Integer.parseInt(br.readLine());

        bfs();
        for (int i = 1; i <= N; i++) {
            if (visited[i]) {
                ans++;
                continue;
            }
        }

        System.out.println(ans);
    }

    static void bfs() {
        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        visited[start] = true;

        while (!q.isEmpty()) {
            int now = q.poll();
            int[] dir = { bridge[now], -bridge[now] };
            for (int i = 0; i < 2; i++) {
                int temp = now + dir[i];
                if (temp < 1 || temp > N) {
                    continue;
                }
                if (visited[temp]) {
                    continue;
                }
                q.add(temp);
                visited[temp] = true;
            }
        }
    }
}
