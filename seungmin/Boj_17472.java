import java.io.*;
import java.util.*;

public class Boj_17472 {
    static class Bridge {
        int from, to, len;

        Bridge(int from, int to, int len) {
            this.from = from;
            this.to = to;
            this.len = len;
        }
    }

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static List<Bridge> bridges = new ArrayList<>();
    static boolean[][] visited;
    static int[][] map, dir = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };
    static int[] parent;
    static int N, M, ans;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N + 1][M + 1];
        visited = new boolean[N + 1][M + 1];
        for (int y = 1; y <= N; y++) {
            st = new StringTokenizer(br.readLine());
            for (int x = 1; x <= M; x++) {
                map[y][x] = Integer.parseInt(st.nextToken());
            }
        }

        int number = 1;
        for (int y = 1; y <= N; y++) {
            for (int x = 1; x <= M; x++) {
                if (visited[y][x] || map[y][x] == 0) {
                    continue;
                }
                giveNumber(y, x, number);
                number++;
            }
        }

        parent = new int[number];
        for (int i = 1; i < number; i++) {
            parent[i] = i;
        }

        for (int y = 1; y <= N; y++) {
            for (int x = 1; x <= M; x++) {
                if (map[y][x] == 0) {
                    continue;
                }
                findBridgeCand(y, x);
            }
        }

        Collections.sort(bridges, (b1, b2) -> b1.len - b2.len);

        for (Bridge bridge : bridges) {
            if (bridge.len < 2) {
                continue;
            }
            if (find(bridge.from) == find(bridge.to)) {
                continue;
            }

            union(bridge.from, bridge.to);
            ans += bridge.len;
        }

        int self = 0;
        for (int i = 1; i < number; i++) {
            if (parent[i] == i) {
                self++;
                if (self > 1) {
                    System.out.println(-1);
                    return;
                }
                continue;
            }
        }

        System.out.println(ans);
    }

    static void giveNumber(int y, int x, int number) {
        Queue<Integer> q = new LinkedList<>();
        q.add(y);
        q.add(x);
        visited[y][x] = true;
        map[y][x] = number;

        while (!q.isEmpty()) {
            int nowY = q.poll();
            int nowX = q.poll();
            for (int i = 0; i < 4; i++) {
                int dy = nowY + dir[i][0];
                int dx = nowX + dir[i][1];
                if (dy < 1 || dy > N || dx < 1 || dx > M) {
                    continue;
                }
                if (visited[dy][dx] || map[dy][dx] == 0) {
                    continue;
                }

                q.add(dy);
                q.add(dx);
                visited[dy][dx] = true;
                map[dy][dx] = number;
            }
        }
    }

    static void findBridgeCand(int y, int x) {
        findWidth(y, x);
        findHeight(y, x);
    }

    static void findWidth(int y, int x) {
        visited = new boolean[N + 1][M + 1];
        int curNumber = map[y][x];
        Queue<Integer> q = new LinkedList<>();
        q.add(y);
        q.add(x);
        q.add(0);
        visited[y][x] = true;

        while (!q.isEmpty()) {
            int nowY = q.poll();
            int nowX = q.poll();
            int nowDist = q.poll();
            if (map[nowY][nowX] != curNumber && map[nowY][nowX] != 0) {
                bridges.add(new Bridge(curNumber, map[nowY][nowX], nowDist - 1));
                return;
            }
            for (int i = 2; i < 4; i++) {
                int dy = nowY + dir[i][0];
                int dx = nowX + dir[i][1];
                if (dy < 1 || dy > N || dx < 1 || dx > M) {
                    continue;
                }
                if (visited[dy][dx] || map[dy][dx] == curNumber) {
                    continue;
                }

                q.add(dy);
                q.add(dx);
                q.add(nowDist + 1);
                visited[dy][dx] = true;
            }
        }
    }

    static void findHeight(int y, int x) {
        visited = new boolean[N + 1][M + 1];
        int curNumber = map[y][x];
        Queue<Integer> q = new LinkedList<>();
        q.add(y);
        q.add(x);
        q.add(0);
        visited[y][x] = true;

        while (!q.isEmpty()) {
            int nowY = q.poll();
            int nowX = q.poll();
            int nowDist = q.poll();
            if (map[nowY][nowX] != curNumber && map[nowY][nowX] != 0) {
                bridges.add(new Bridge(curNumber, map[nowY][nowX], nowDist - 1));
                return;
            }
            for (int i = 0; i < 2; i++) {
                int dy = nowY + dir[i][0];
                int dx = nowX + dir[i][1];
                if (dy < 1 || dy > N || dx < 1 || dx > M) {
                    continue;
                }
                if (visited[dy][dx] || map[dy][dx] == curNumber) {
                    continue;
                }

                q.add(dy);
                q.add(dx);
                q.add(nowDist + 1);
                visited[dy][dx] = true;
            }
        }
    }

    static int find(int target) {
        if (parent[target] == target) {
            return target;
        }

        return parent[target] = find(parent[target]);
    }

    static void union(int from, int to) {
        parent[find(to)] = find(from);
    }
}
