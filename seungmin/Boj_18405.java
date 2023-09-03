import java.io.*;
import java.util.*;

public class Boj_18405 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static List<int[]> viruses = new ArrayList<>();
    static int[][] map, dist, dir = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };
    static int N, K, S, X, Y;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());

        map = new int[N + 1][N + 1];
        dist = new int[N + 1][N + 1];
        for (int y = 1; y <= N; y++) {
            st = new StringTokenizer(br.readLine());
            for (int x = 1; x <= N; x++) {
                map[y][x] = Integer.parseInt(st.nextToken());
                dist[y][x] = Integer.MAX_VALUE;
                if (map[y][x] != 0) {
                    viruses.add(new int[] { map[y][x], y, x });
                }
            }
        }

        st = new StringTokenizer(br.readLine());
        S = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());
        Y = Integer.parseInt(st.nextToken());

        Collections.sort(viruses, (v1, v2) -> v1[0] - v2[0]);

        bfs();

        if (dist[X][Y] > S) {
            System.out.println(0);
        } else {
            System.out.println(map[X][Y]);
        }
    }

    static void bfs() {
        Queue<Integer> q = new LinkedList<>();
        for (int[] virus : viruses) {
            q.add(virus[1]);
            q.add(virus[2]);
            dist[virus[1]][virus[2]] = 0;
        }

        while (!q.isEmpty()) {
            int nowY = q.poll();
            int nowX = q.poll();
            for (int i = 0; i < 4; i++) {
                int dy = nowY + dir[i][0];
                int dx = nowX + dir[i][1];
                if (dy < 1 || dy > N || dx < 1 || dx > N) {
                    continue;
                }
                if (dist[dy][dx] != Integer.MAX_VALUE || map[dy][dx] != 0) {
                    continue;
                }
                map[dy][dx] = map[nowY][nowX];
                q.add(dy);
                q.add(dx);
                dist[dy][dx] = dist[nowY][nowX] + 1;
            }
        }
    }
}
