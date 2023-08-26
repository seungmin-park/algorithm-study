import java.io.*;
import java.util.*;

public class Boj_1388 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static String[] floor;
    static boolean[][] checked;
    static int N, M, ans;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        floor = new String[N];
        checked = new boolean[N][M];
        for (int i = 0; i < N; i++) {
            floor[i] = br.readLine();
        }

        for (int row = 0; row < N; row++) {
            for (int col = 0; col < M; col++) {
                if (checked[row][col]) {
                    continue;
                }
                dfs(row, col);
                ans++;
            }
        }

        System.out.println(ans);
    }

    static void dfs(int y, int x) {
        checked[y][x] = true;

        if (floor[y].charAt(x) == '-') {
            if (x + 1 >= M || floor[y].charAt(x + 1) != '-') {
                return;
            }
            dfs(y, x + 1);
        } else {
            if (y + 1 >= N || floor[y + 1].charAt(x) != '|') {
                return;
            }
            dfs(y + 1, x);
        }
    }
}
