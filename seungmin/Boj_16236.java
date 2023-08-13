import java.io.*;
import java.util.*;

public class Boj_16236 {
    static class Shark {
        int y, x, size, eatCount;

        Shark(int y, int x) {
            this.y = y;
            this.x = x;
            this.size = 2;
        }

        public void eat() {
            if (++eatCount == size) {
                size++;
                eatCount = 0;
            }
        }
    }

    static class Feed {
        int y, x, dist;

        Feed(int y, int x, int size, int dist) {
            this.y = y;
            this.x = x;
            this.dist = dist;
        }
    }

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static List<Feed> feeds = new ArrayList<>();
    static Shark babyShark;
    static boolean[][] visited;
    static int[][] map, dir = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };
    static int N, ans;

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        map = new int[N + 1][N + 1];
        visited = new boolean[N + 1][N + 1];

        for (int col = 1; col <= N; col++) {
            st = new StringTokenizer(br.readLine());
            for (int row = 1; row <= N; row++) {
                map[col][row] = Integer.parseInt(st.nextToken());
                if (map[col][row] == 0) {
                    continue;
                }
                if (map[col][row] == 9) {
                    babyShark = new Shark(col, row);
                    continue;
                }
            }
        }

        while (true) {
            feeds.clear();
            if (!searchDistance()) {
                break;
            }
            sort();
            hunt(feeds.remove(0));
        }

        System.out.println(ans);
    }

    static boolean searchDistance() {
        boolean flag = false;
        Queue<Integer> q = new LinkedList<>();
        q.add(babyShark.y);
        q.add(babyShark.x);
        q.add(0);
        visited[babyShark.y][babyShark.x] = true;

        while (!q.isEmpty()) {
            int nowY = q.poll();
            int nowX = q.poll();
            int nowDist = q.poll();
            for (int i = 0; i < 4; i++) {
                int dy = nowY + dir[i][0];
                int dx = nowX + dir[i][1];
                if (dy < 1 || dy > N || dx < 1 || dx > N) {
                    continue;
                }
                if (visited[dy][dx] || map[dy][dx] > babyShark.size) {
                    continue;
                }
                q.add(dy);
                q.add(dx);
                q.add(nowDist + 1);
                visited[dy][dx] = true;
                if (map[dy][dx] != 0 && map[dy][dx] < babyShark.size) {
                    flag = true;
                    feeds.add(new Feed(dy, dx, map[dy][dx], nowDist + 1));
                }
            }
        }

        return flag;
    }

    static void sort() {
        Collections.sort(feeds, (f1, f2) -> {
            if (f1.dist != f2.dist) {
                return f1.dist - f2.dist;
            }
            if (f1.y != f2.y) {
                return f1.y - f2.y;
            }
            return f1.x - f2.x;
        });
    }

    static void hunt(Feed target) {
        babyShark.eat();
        map[babyShark.y][babyShark.x] = 0;
        babyShark.y = target.y;
        babyShark.x = target.x;
        ans += target.dist;
        map[target.y][target.x] = 0;
        for (int col = 1; col <= N; col++) {
            for (int row = 1; row <= N; row++) {
                visited[col][row] = false;
            }
        }
    }
}