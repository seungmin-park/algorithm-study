import java.io.*;
import java.util.*;

public class Boj_17070 {
    static class Location {
        int y, x;
        State state;

        Location(int y, int x, State state) {
            this.y = y;
            this.x = x;
            this.state = state;
        }

        int[][] moveDir() {
            if (state == State.HORIZONAL) {
                return new int[][] { { 0, 1 }, { 1, 1 } };
            }
            if (state == State.VERTICAL) {
                return new int[][] { { 1, 0 }, { 1, 1 } };
            }

            return new int[][] { { 0, 1 }, { 1, 0 }, { 1, 1 } };
        }
    }

    static enum State {
        HORIZONAL, VERTICAL, DIAGONAL
    }

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int[][] map;
    static int N, ans;
    static final int WALL = 1;
    static final int EMPTY = 0;

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        map = new int[N + 1][N + 1];
        for (int y = 1; y <= N; y++) {
            st = new StringTokenizer(br.readLine());
            for (int x = 1; x <= N; x++) {
                map[y][x] = Integer.parseInt(st.nextToken());
            }
        }

        if (map[N][N] == WALL) {
            System.out.println(0);
        }

        bfs();

        System.out.println(ans);
    }

    static void bfs() {
        Queue<Location> q = new LinkedList<>();
        q.add(new Location(1, 2, State.HORIZONAL));

        while (!q.isEmpty()) {
            Location now = q.poll();
            int nowY = now.y;
            int nowX = now.x;
            State nowState = now.state;
            if (nowY == nowX && nowX == N) {
                ans++;
            }
            int[][] dir = now.moveDir();
            for (int i = 0; i < dir.length; i++) {
                int dy = nowY + dir[i][0];
                int dx = nowX + dir[i][1];
                if (dy < 1 || dy > N || dx < 1 || dx > N) {
                    continue;
                }
                if (map[dy][dx] == WALL
                        || (i == dir.length - 1 && (map[dy - 1][dx] == WALL || map[dy][dx - 1] == WALL))) {
                    continue;
                }

                State dState = getState(i, dir.length, nowState);
                q.add(new Location(dy, dx, dState));
            }
        }
    }

    static State getState(int i, int length, State state) {
        if (state == State.DIAGONAL) {
            return State.values()[i];
        }
        if (i == length - 1) {
            return State.DIAGONAL;
        }
        return state;
    }
}
