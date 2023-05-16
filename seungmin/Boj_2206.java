import java.io.*;
import java.util.*;

public class Boj_2206 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int[][][] distance;
    static int[][] dir = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };
    static int[][] map;
    static int N, M;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N + 1][M + 1];
        distance = new int[2][N + 1][M + 1];

        for (int col = 1; col <= N; col++) {
            String next = br.readLine();
            for (int row = 1; row <= M; row++) {
                map[col][row] = next.charAt(row - 1) - 48;
            }
        }

        bfs();
        if (distance[0][N][M] != 0 && distance[1][N][M] != 0) {
            System.out.println(Math.min(distance[0][N][M], distance[1][N][M]));
        } else if (distance[0][N][M] != 0) {
            System.out.println(distance[0][N][M]);
        } else if (distance[1][N][M] != 0) {
            System.out.println(distance[1][N][M]);
        } else {
            System.out.println(-1);
        }
    }

    static void bfs() {
        Queue<Integer> q = new LinkedList<>();
        q.add(1);
        q.add(1);
        q.add(0);
        distance[0][1][1] = 1;

        while (!q.isEmpty()) {
            int nowY = q.poll();
            int nowX = q.poll();
            int destoryed = q.poll();
            for (int i = 0; i < 4; i++) {
                int dy = nowY + dir[i][0];
                int dx = nowX + dir[i][1];
                if (dy < 1 || dy > N || dx < 1 || dx > M)
                    continue;
                if (map[dy][dx] == 1) {
                    if (destoryed == 0) {
                        distance[1][dy][dx] = distance[0][nowY][nowX] + 1;
                        q.add(dy);
                        q.add(dx);
                        q.add(1);
                    }
                } else {
                    if (distance[destoryed][dy][dx] == 0) {
                        distance[destoryed][dy][dx] = distance[destoryed][nowY][nowX] + 1;
                        q.add(dy);
                        q.add(dx);
                        q.add(destoryed);
                    }
                }
            }
        }
    }
}
