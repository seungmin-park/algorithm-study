import java.io.*;
import java.util.*;

public class Boj_20046 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int[][] arr, dist, dir = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };
    static int N, M;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[N + 1][M + 1];
        dist = new int[N + 1][M + 1];
        for (int i = 1; i <= N; i++) {
            Arrays.fill(dist[i], Integer.MAX_VALUE);
        }

        for (int n = 1; n <= N; n++) {
            st = new StringTokenizer(br.readLine());
            for (int m = 1; m <= M; m++) {
                arr[n][m] = Integer.parseInt(st.nextToken());
            }
        }

        if (arr[1][1] == -1) {
            System.out.println(-1);
            return;
        }
        bfs();

        System.out.println(dist[N][M] == Integer.MAX_VALUE ? -1 : dist[N][M]);
    }

    static void bfs() {
        PriorityQueue<int[]> q = new PriorityQueue<>((n1, n2) -> {
            return n1[2] - n2[2];
        });
        q.add(new int[] { 1, 1, arr[1][1] });
        dist[1][1] = arr[1][1];
        while (!q.isEmpty()) {
            int[] now = q.poll();
            int nowY = now[0];
            int nowX = now[1];
            int nowDsit = now[2];
            if (dist[nowY][nowX] < nowDsit) {
                continue;
            }
            for (int i = 0; i < 4; i++) {
                int dy = nowY + dir[i][0];
                int dx = nowX + dir[i][1];
                if (dy < 1 || dy > N || dx < 1 || dx > M) {
                    continue;
                }
                if (arr[dy][dx] == -1) {
                    continue;
                }
                if (dist[dy][dx] > dist[nowY][nowX] + arr[dy][dx]) {
                    dist[dy][dx] = dist[nowY][nowX] + arr[dy][dx];
                    q.add(new int[] { dy, dx, dist[dy][dx] });
                }
            }
        }
    }
}