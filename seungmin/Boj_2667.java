import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

public class Boj_2667 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static ArrayList<Integer> townGroup = new ArrayList<>();
    static int[][] dir = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    static int[][] town;
    static boolean[][] visit;
    static int N;

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        town = new int[N + 1][N + 1];
        visit = new boolean[N + 1][N + 1];

        for (int i = 1; i <= N; i++) {
            String row = br.readLine();
            for (int j = 1; j <= N; j++) {
                town[i][j] = row.charAt(j - 1) - 48;
            }
        }

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                if (town[i][j] == 0 || visit[i][j]) {
                    continue;
                }
                townGroup.add(bfs(i, j));
            }
        }

        sb.append(townGroup.size());

        Collections.sort(townGroup);
        for (Integer groupSize : townGroup) {
            sb.append("\n").append(groupSize);
        }

        System.out.print(sb.toString());
    }

    static int bfs(int y, int x) {
        Queue<int[]> q = new LinkedList<>();
        visit[y][x] = true;
        q.add(new int[]{y, x});
        int cnt = 1;

        while (!q.isEmpty()) {
            int[] now = q.poll();
            int nowY = now[0];
            int nowX = now[1];
            for (int i = 0; i < 4; i++) {
                int dy = nowY + dir[i][0];
                int dx = nowX + dir[i][1];
                if (dy < 0 || dy > N || dx < 0 || dx > N) {
                    continue;
                }
                if (town[dy][dx] == 0 || visit[dy][dx]) {
                    continue;
                }
                cnt++;
                visit[dy][dx] = true;
                q.add(new int[]{dy, dx});
            }
        }

        return cnt;
    }
}
