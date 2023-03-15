import java.util.*;
import java.io.*;

public class Boj_1987 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static String[] alphabets;
    static int[] selected = new int[26];
    static int[][] dir = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };
    static int R, C, ans = Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        alphabets = new String[R + 1];
        for (int i = 1; i <= R; i++) {
            alphabets[i] = br.readLine();
        }
        selected[alphabets[1].charAt(0) - 65] = 1;
        dfs(1, 0, 1);

        System.out.println(ans);
    }

    static void dfs(int col, int row, int depth) {
        for (int i = 0; i < 4; i++) {
            int dy = col + dir[i][0];
            int dx = row + dir[i][1];
            if (dy < 1 || dy > R || dx < 0 || dx > C - 1)
                continue;
            if (selected[alphabets[dy].charAt(dx) - 65] != 0)
                continue;
            selected[alphabets[dy].charAt(dx) - 65] = 1;
            dfs(dy, dx, depth + 1);
            selected[alphabets[dy].charAt(dx) - 65] = 0;
        }

        ans = Math.max(ans, depth);
    }
}
