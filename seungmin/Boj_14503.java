import java.io.*;
import java.util.*;

public class Boj_14503 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static boolean[][] isCleaned;
    static int[][] house;
    static int[][] dir = { { 1, 0 }, { 0, -1 }, { -1, 0 }, { 0, 1 } };
    static int N, M, startY, startX, startDir;
    static final int NORTH = 0;
    static final int EAST = 1;
    static final int WEST = 3;
    static final int SOUTH = 2;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        house = new int[N][M];
        isCleaned = new boolean[N][M];

        st = new StringTokenizer(br.readLine());
        startY = Integer.parseInt(st.nextToken());
        startX = Integer.parseInt(st.nextToken());
        startDir = Integer.parseInt(st.nextToken());

        for (int col = 0; col < N; col++) {
            st = new StringTokenizer(br.readLine());
            for (int row = 0; row < M; row++) {
                house[col][row] = Integer.parseInt(st.nextToken());
            }
        }

        System.out.println(cleanHouse());
    }

    static int cleanHouse() {
        int cnt = 1;
        int curY = startY;
        int curX = startX;
        int curDir = startDir;
        isCleaned[curY][curX] = true;

        while (true) {
            boolean flag = false;
            for (int i = 0; i < 4; i++) {
                int dy = curY + dir[i][0];
                int dx = curX + dir[i][1];
                if (dy < 0 || dy > N - 1 || dx < 0 || dx > M - 1)
                    continue;
                if (house[dy][dx] == 1 || isCleaned[dy][dx])
                    continue;
                flag = true;
                continue;
            }
            if (flag) {
                if (curDir == NORTH) {
                    curDir = WEST;
                    if (!isCleaned[curY][curX - 1] && house[curY][curX - 1] == 0) {
                        curX--;
                        isCleaned[curY][curX] = true;
                        cnt++;
                    }
                } else if (curDir == WEST) {
                    curDir = SOUTH;
                    if (!isCleaned[curY + 1][curX] && house[curY + 1][curX] != 1) {
                        curY++;
                        isCleaned[curY][curX] = true;
                        cnt++;
                    }
                } else if (curDir == SOUTH) {
                    curDir = EAST;
                    if (!isCleaned[curY][curX + 1] && house[curY][curX + 1] != 1) {
                        curX++;
                        isCleaned[curY][curX] = true;
                        cnt++;
                    }
                } else if (curDir == EAST) {
                    curDir = NORTH;
                    if (!isCleaned[curY - 1][curX] && house[curY - 1][curX] != 1) {
                        curY--;
                        isCleaned[curY][curX] = true;
                        cnt++;
                    }
                }
            } else {
                if (curDir == NORTH) {
                    if (house[curY + 1][curX] == 1) {
                        break;
                    } else {
                        curY++;
                    }
                } else if (curDir == SOUTH) {
                    if (house[curY - 1][curX] == 1) {
                        break;
                    } else {
                        curY--;
                    }
                } else if (curDir == EAST) {
                    if (house[curY][curX - 1] == 1) {
                        break;
                    } else {
                        curX--;
                    }
                } else if (curDir == WEST) {
                    if (house[curY][curX + 1] == 1) {
                        break;
                    } else {
                        curX++;
                    }
                }
            }
        }

        return cnt;
    }
}
