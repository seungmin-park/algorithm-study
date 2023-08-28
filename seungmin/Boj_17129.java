import java.io.*;
import java.util.*;

public class Boj_17129 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static String[] map;
    static int[][] dist, dir = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };
    static int N, M, startY, startX;
    static final char START = '2';
    static final List<Character> TARGETS = List.of('3', '4', '5');

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        dist = new int[N][M];
        map = new String[N];

        for (int i = 0; i < N; i++) {
            map[i] = br.readLine();
            for (int j = 0; j < M; j++) {
                dist[i][j] = Integer.MAX_VALUE;
                if (map[i].charAt(j) == START) {
                    startY = i;
                    startX = j;
                }
            }
        }

        int result = bfs();
        if (result != -1) {
            sb.append("TAK").append("\n").append(result);
        } else {
            sb.append("NIE");
        }

        System.out.println(sb);
    }

    static int bfs() {
        Queue<Integer> q = new LinkedList<>();
        q.add(startY);
        q.add(startX);
        dist[startY][startX] = 0;

        while (!q.isEmpty()) {
            int nowY = q.poll();
            int nowX = q.poll();
            if (TARGETS.contains(map[nowY].charAt(nowX))) {
                return dist[nowY][nowX];
            }

            for (int i = 0; i < 4; i++) {
                int dy = nowY + dir[i][0];
                int dx = nowX + dir[i][1];
                if (dy < 0 || dy >= N || dx < 0 || dx >= M) {
                    continue;
                }
                if (dist[dy][dx] != Integer.MAX_VALUE || map[dy].charAt(dx) == '1') {
                    continue;
                }

                q.add(dy);
                q.add(dx);
                dist[dy][dx] = dist[nowY][nowX] + 1;
            }
        }

        return -1;
    }
}
