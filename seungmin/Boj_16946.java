import java.io.*;
import java.util.*;

public class Boj_16946 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static List<Integer> cand = new ArrayList<>();
    static boolean[][] visited;
    static int[][] map, distance, dir = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };
    static int N, M;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N + 1][M + 1];
        distance = new int[N + 1][M + 1];
        visited = new boolean[N + 1][M + 1];

        for (int y = 1; y <= N; y++) {
            String input = br.readLine();
            for (int x = 1; x <= M; x++) {
                map[y][x] = input.charAt(x - 1) - '0';
                distance[y][x] = -1;
            }
        }

        int num = 0;
        for (int y = 1; y <= N; y++) {
            for (int x = 1; x <= M; x++) {
                if (visited[y][x] || map[y][x] == 1) {
                    continue;
                }
                cand.add(bfs(y, x, num));
                num++;
            }
        }

        for (int y = 1; y <= N; y++) {
            for (int x = 1; x <= M; x++) {
                if (map[y][x] == 1) {
                    sb.append(getDist(y, x));
                    continue;
                }
                sb.append(0);
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }

    static int bfs(int y, int x, int num) {
        int cnt = 1;
        Queue<Integer> q = new LinkedList<>();
        q.add(y);
        q.add(x);
        visited[y][x] = true;

        while (!q.isEmpty()) {
            int nowY = q.poll();
            int nowX = q.poll();
            distance[nowY][nowX] = num;

            for (int i = 0; i < 4; i++) {
                int dy = nowY + dir[i][0];
                int dx = nowX + dir[i][1];
                if (dy < 1 || dy > N || dx < 1 || dx > M) {
                    continue;
                }
                if (visited[dy][dx] || map[dy][dx] == 1) {
                    continue;
                }

                cnt++;
                q.add(dy);
                q.add(dx);
                visited[dy][dx] = true;
            }
        }
        return cnt;
    }

    static int getDist(int y, int x) {
        Set<Integer> sel = new HashSet<>();
        for (int i = 0; i < 4; i++) {
            int dy = y + dir[i][0];
            int dx = x + dir[i][1];
            if (dy < 1 || dy > N || dx < 1 || dx > M) {
                continue;
            }
            if (map[dy][dx] == 1) {
                continue;
            }
            sel.add(distance[dy][dx]);
        }

        int sum = 1;
        for (int s : sel) {
            sum += cand.get(s);
        }
        return sum % 10;
    }
}
