import java.io.*;
import java.util.*;

public class Boj_2589 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static String[] land;
    static int[][] distance, dir = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };
    static int N, M, ans;

    static final char SEA = 'W';
    static final char LAND = 'L';

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        land = new String[N];
        distance = new int[N][M];

        for (int col = 0; col < N; col++) {
            land[col] = br.readLine();
        }

        for (int col = 0; col < N; col++) {
            for (int row = 0; row < M; row++) {
                if (land[col].charAt(row) == SEA) {
                    continue;
                }
                init();
                ans = Math.max(ans, bfs(col, row));
            }
        }

        System.out.println(ans);
    }

    static void init() {
        for (int col = 0; col < N; col++) {
            Arrays.fill(distance[col], -1);
        }
    }

    static int bfs(int y, int x) {
        int dist = -1;
        Queue<Integer> q = new LinkedList<>();
        q.add(y);
        q.add(x);

        distance[y][x] = 0;

        while (!q.isEmpty()) {
            int nowY = q.poll();
            int nowX = q.poll();
            for (int i = 0; i < 4; i++) {
                int dy = nowY + dir[i][0];
                int dx = nowX + dir[i][1];
                if (dy < 0 || dy >= N || dx < 0 || dx >= M) {
                    continue;
                }
                if (land[dy].charAt(dx) == SEA || distance[dy][dx] != -1) {
                    continue;
                }
                q.add(dy);
                q.add(dx);
                distance[dy][dx] = distance[nowY][nowX] + 1;

                dist = Math.max(distance[dy][dx], dist);
            }
        }

        return dist;
    }
}