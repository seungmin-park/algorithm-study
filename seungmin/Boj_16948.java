import java.io.*;
import java.util.*;

public class Boj_16948 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int[][] board, dir = { { -1, -2 }, { 1, -2 }, { -2, 0 }, { 2, 0 }, { -1, 2 }, { 1, 2 } };
    static int N, startY, startX, goalY, goalX;

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        board = new int[N][N];

        for (int col = 0; col < N; col++) {
            for (int row = 0; row < N; row++) {
                board[col][row] = -1;
            }
        }

        st = new StringTokenizer(br.readLine());
        startX = Integer.parseInt(st.nextToken());
        startY = Integer.parseInt(st.nextToken());
        goalX = Integer.parseInt(st.nextToken());
        goalY = Integer.parseInt(st.nextToken());

        bfs();

        System.out.println(board[goalY][goalX]);
    }

    static void bfs() {
        Queue<Integer> q = new LinkedList<>();
        q.add(startY);
        q.add(startX);
        board[startY][startX] = 0;

        while (!q.isEmpty()) {
            int nowY = q.poll();
            int nowX = q.poll();
            for (int i = 0; i < 6; i++) {
                int dy = nowY + dir[i][0];
                int dx = nowX + dir[i][1];
                if (dy < 0 || dy >= N || dx < 0 || dx >= N) {
                    continue;
                }
                if (board[dy][dx] != -1 || board[dy][dx] > board[nowY][nowX] + 1) {
                    continue;
                }

                board[dy][dx] = board[nowY][nowX] + 1;
                q.add(dy);
                q.add(dx);
            }
        }
    }
}