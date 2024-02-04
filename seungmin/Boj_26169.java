import java.io.*;
import java.util.*;

public class Boj_26169 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int[][] map, dir = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    static int startY, startX, ans;

    public static void main(String[] args) throws IOException {
        map = new int[5][5];
        for (int y = 0; y < 5; y++) {
            st = new StringTokenizer(br.readLine());
            for (int x = 0; x < 5; x++) {
                map[y][x] = Integer.parseInt(st.nextToken());
            }
        }

        st = new StringTokenizer(br.readLine());
        startY = Integer.parseInt(st.nextToken());
        startX = Integer.parseInt(st.nextToken());

        if (map[startY][startX] == 1) {
            bfs(startY, startX, 0, 1);
        } else {
            bfs(startY, startX, 0, 0);
        }

        System.out.println(ans);
    }

    static void bfs(int y, int x, int moveCnt, int eatCnt) {
        if (eatCnt > 1) {
            ans = 1;
            return;
        }
        if (moveCnt > 2) {
            return;
        }
        for (int i = 0; i < 4; i++) {
            int dy = y + dir[i][0];
            int dx = x + dir[i][1];
            if (dy < 0 || dy > 4 || dx < 0 || dx > 4) {
                continue;
            }
            if (map[dy][dx] == -1) {
                continue;
            }

            if (map[dy][dx] == 1) {
                map[y][x] = -1;
                bfs(dy, dx, moveCnt + 1, eatCnt + 1);
                map[y][x] = 1;
            } else {
                map[y][x] = -1;
                bfs(dy, dx, moveCnt + 1, eatCnt);
                map[y][x] = 0;
            }
            if (ans == 1) {
                return;
            }
        }
    }

}
