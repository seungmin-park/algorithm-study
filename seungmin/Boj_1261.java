import java.io.*;
import java.util.*;

public class Boj_1261 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int[][] miro, breakCnt, dir = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };
    static int N, M;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        miro = new int[N + 1][M + 1];
        breakCnt = new int[N + 1][M + 1];

        for (int col = 1; col <= N; col++) {
            String input = br.readLine();
            for (int row = 1; row <= M; row++) {
                miro[col][row] = input.charAt(row - 1) - 48;
                breakCnt[col][row] = Integer.MAX_VALUE;
            }
        }

        bfs();
        System.out.println(breakCnt[N][M]);
    }

    static void bfs() {
        Queue<Integer> q = new LinkedList<>();
        q.add(1);
        q.add(1);
        breakCnt[1][1] = 0;

        while (!q.isEmpty()) {
            int nowY = q.poll();
            int nowX = q.poll();
            for (int i = 0; i < 4; i++) {
                int dy = nowY + dir[i][0];
                int dx = nowX + dir[i][1];
                if (dy < 1 || dy > N || dx < 1 || dx > M) {
                    continue;
                }
                if (miro[dy][dx] == 1) {
                    if (breakCnt[dy][dx] <= breakCnt[nowY][nowX] + 1) {
                        continue;
                    }
                    breakCnt[dy][dx] = breakCnt[nowY][nowX] + 1;
                } else {
                    if (breakCnt[dy][dx] <= breakCnt[nowY][nowX]) {
                        continue;
                    }
                    breakCnt[dy][dx] = breakCnt[nowY][nowX];
                }
                q.add(dy);
                q.add(dx);
            }
        }
    }
}
