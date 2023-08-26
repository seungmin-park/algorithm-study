import java.io.*;
import java.util.*;

public class Boj_17141 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static List<int[]> viruses = new ArrayList<>();
    static boolean[][] visited;
    static boolean[] checked;
    static int[][] lab, dir = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };
    static int N, M, emptyCnt, ans = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        lab = new int[N + 1][N + 1];

        for (int y = 1; y <= N; y++) {
            st = new StringTokenizer(br.readLine());
            for (int x = 1; x <= N; x++) {
                lab[y][x] = Integer.parseInt(st.nextToken());
                if (lab[y][x] == 2) {
                    viruses.add(new int[] { y, x });
                    continue;
                }
                if (lab[y][x] == 0) {
                    emptyCnt++;
                }
            }
        }
        checked = new boolean[viruses.size()];
        emptyCnt += viruses.size() - M;

        func(0, 0);

        if (emptyCnt == 0 && viruses.size() > 0) {
            System.out.println(0);
        } else {
            System.out.println(ans == Integer.MAX_VALUE ? -1 : ans);
        }
    }

    static void func(int k, int cnt) {
        if (cnt == M) {
            bfs();
            return;
        }

        for (int i = k; i < viruses.size(); i++) {
            int[] now = viruses.get(i);
            int nowY = now[0];
            int nowX = now[1];
            lab[nowY][nowX] = -1;
            checked[i] = true;
            func(i + 1, cnt + 1);
            checked[i] = false;
            lab[nowY][nowX] = 2;
        }
    }

    static void bfs() {
        Queue<Integer> q = new LinkedList<>();
        visited = new boolean[N + 1][N + 1];
        int cnt = emptyCnt;

        for (int i = 0; i < checked.length; i++) {
            if (checked[i]) {
                int[] now = viruses.get(i);
                int nowY = now[0];
                int nowX = now[1];
                q.add(nowY);
                q.add(nowX);
                q.add(0);
                visited[nowY][nowX] = true;
            }
        }

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
                if (visited[dy][dx] || lab[dy][dx] == 1) {
                    continue;
                }
                if (lab[dy][dx] == 0 || lab[dy][dx] == 2) {
                    cnt--;
                }
                if (cnt == 0) {
                    ans = Math.min(ans, nowDist + 1);
                    return;
                }
                q.add(dy);
                q.add(dx);
                q.add(nowDist + 1);
                visited[dy][dx] = true;
            }
        }
    }
}
