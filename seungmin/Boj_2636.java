import java.io.*;
import java.util.*;

public class Boj_2636 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static List<int[]> detected;
    static boolean[][] visited;
    static int[][] map, dir = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };
    static int N, M, cheeseCnt, day;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N + 1][M + 1];

        for (int col = 1; col <= N; col++) {
            st = new StringTokenizer(br.readLine());
            for (int row = 1; row <= M; row++) {
                map[col][row] = Integer.parseInt(st.nextToken());
            }
        }

        while (true) {
            visited = new boolean[N + 1][M + 1];
            detected = new ArrayList<>();
            bfs(1, 1);
            if (detected.size() < 1) {
                break;
            }
            day++;
            cheeseCnt = detected.size();
            for (int[] detect : detected) {
                map[detect[0]][detect[1]] = 0;
            }
        }
        sb.append(day).append("\n").append(cheeseCnt);
        bw.write(sb.toString());
        bw.flush();
    }

    static void bfs(int y, int x) {
        Queue<Integer> q = new LinkedList<>();
        q.add(y);
        q.add(x);
        visited[y][x] = true;

        while (!q.isEmpty()) {
            int nowY = q.poll();
            int nowX = q.poll();
            for (int i = 0; i < 4; i++) {
                int dy = nowY + dir[i][0];
                int dx = nowX + dir[i][1];
                if (dy < 1 || dy > N || dx < 1 || dx > M) {
                    continue;
                }
                if (visited[dy][dx]) {
                    continue;
                }
                if (map[dy][dx] == 1) {
                    detected.add(new int[] { dy, dx });
                    visited[dy][dx] = true;
                    continue;
                }
                q.add(dy);
                q.add(dx);
                visited[dy][dx] = true;
            }
        }
    }
}
