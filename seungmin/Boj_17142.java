import java.io.*;
import java.util.*;

public class Boj_17142 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static List<int[]> viruses = new ArrayList<>();
    static boolean[][] visited;
    static int[][] lab, dir = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };
    static int[] cand;
    static int N, M, originEmptySpaceCnt, ans = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        cand = new int[M];
        lab = new int[N + 1][N + 1];
        for (int col = 1; col <= N; col++) {
            st = new StringTokenizer(br.readLine());
            for (int row = 1; row <= N; row++) {
                lab[col][row] = Integer.parseInt(st.nextToken());
                if (lab[col][row] == 0) {
                    originEmptySpaceCnt++;
                } else if (lab[col][row] == 2) {
                    viruses.add(new int[] { col, row });
                }
            }
        }

        if (originEmptySpaceCnt == 0) {
            System.out.println(0);
            return;
        }
        func(0, 0);

        System.out.println(ans == Integer.MAX_VALUE ? -1 : ans);
    }

    static void func(int k, int cnt) {
        if (cnt == M) {
            bfs(originEmptySpaceCnt);
            return;
        }

        for (int i = k; i < viruses.size(); i++) {
            cand[cnt] = i;
            func(i + 1, cnt + 1);
        }
    }

    static void bfs(int emptySpaceCnt) {
        Queue<Integer> q = new LinkedList<>();
        visited = new boolean[N + 1][N + 1];

        for (int i = 0; i < M; i++) {
            int c = cand[i];
            int[] virus = viruses.get(c);
            q.add(virus[0]);
            q.add(virus[1]);
            q.add(0);
            visited[virus[0]][virus[1]] = true;
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
                if (lab[dy][dx] == 0) {
                    emptySpaceCnt--;
                }
                if (emptySpaceCnt == 0) {
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