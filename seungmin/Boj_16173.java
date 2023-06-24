import java.io.*;
import java.util.*;

public class Boj_16173 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static boolean[][] visited;
    static int[][] map;
    static int N;

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());

        map = new int[N + 1][N + 1];
        visited = new boolean[N + 1][N + 1];

        for (int col = 1; col <= N; col++) {
            st = new StringTokenizer(br.readLine());
            for (int row = 1; row <= N; row++) {
                map[col][row] = Integer.parseInt(st.nextToken());
            }
        }

        bfs();

        System.out.println(visited[N][N] ? "HaruHaru" : "Hing");
    }

    static void bfs() {
        Queue<Integer> q = new LinkedList<>();
        q.add(1);
        q.add(1);
        visited[1][1] = true;

        while (!q.isEmpty()) {
            int nowY = q.poll();
            int nowX = q.poll();
            int dy = nowY + map[nowY][nowX];
            if (dy >= 1 && dy <= N && !visited[dy][nowX]) {
                q.add(dy);
                q.add(nowX);
                visited[dy][nowX] = true;
            }

            int dx = nowX + map[nowY][nowX];
            if (dx >= 1 && dx <= N && !visited[nowY][dx]) {
                q.add(nowY);
                q.add(dx);
                visited[nowY][dx] = true;
            }

        }
    }
}
