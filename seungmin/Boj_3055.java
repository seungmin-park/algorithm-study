import java.io.*;
import java.util.*;

public class Boj_3055 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static String[] miro;
    static final char GOAL = 'D';
    static final char START = 'S';
    static final char WATER = '*';
    static final char BLOCK = 'X';
    static int[][] distanceW, distanceS, dir = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };
    static int N, M, goalY, goalX, startY, startX;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        distanceW = new int[N][M];
        distanceS = new int[N][M];

        miro = new String[N];
        for (int col = 0; col < N; col++) {
            miro[col] = br.readLine();
            for (int row = 0; row < M; row++) {
                distanceW[col][row] = -1;
                distanceS[col][row] = -1;
                if (miro[col].charAt(row) == START) {
                    startY = col;
                    startX = row;
                }
                if (miro[col].charAt(row) == GOAL) {
                    goalY = col;
                    goalX = row;
                }
            }
        }

        bfsW();
        bfsS();
        System.out.println(distanceS[goalY][goalX] == -1 ? "KAKTUS" : distanceS[goalY][goalX]);
    }

    static void bfsW() {
        Queue<Integer> q = new LinkedList<>();
        for (int col = 0; col < N; col++) {
            for (int row = 0; row < M; row++) {
                if (miro[col].charAt(row) == WATER) {
                    q.add(col);
                    q.add(row);
                    distanceW[col][row] = 0;
                }
            }
        }

        while (!q.isEmpty()) {
            int nowY = q.poll();
            int nowX = q.poll();
            for (int i = 0; i < 4; i++) {
                int dy = nowY + dir[i][0];
                int dx = nowX + dir[i][1];
                if (dy < 0 || dy > N - 1 || dx < 0 || dx > M - 1) {
                    continue;
                }
                if (miro[dy].charAt(dx) == BLOCK || miro[dy].charAt(dx) == GOAL || distanceW[dy][dx] != -1) {
                    continue;
                }
                distanceW[dy][dx] = distanceW[nowY][nowX] + 1;
                q.add(dy);
                q.add(dx);
            }
        }
    }

    static void bfsS() {
        Queue<Integer> q = new LinkedList<>();
        q.add(startY);
        q.add(startX);
        distanceS[startY][startX] = 0;

        while (!q.isEmpty()) {
            int nowY = q.poll();
            int nowX = q.poll();
            for (int i = 0; i < 4; i++) {
                int dy = nowY + dir[i][0];
                int dx = nowX + dir[i][1];

                if (dy < 0 || dy > N - 1 || dx < 0 || dx > M - 1) {
                    continue;
                }
                if (miro[dy].charAt(dx) == BLOCK || distanceS[dy][dx] != -1) {
                    continue;
                }
                if (distanceW[dy][dx] != -1 && distanceW[dy][dx] <= distanceS[nowY][nowX] + 1) {
                    continue;
                }
                distanceS[dy][dx] = distanceS[nowY][nowX] + 1;
                q.add(dy);
                q.add(dx);
            }
        }
    }
}
