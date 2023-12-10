import java.io.*;
import java.util.*;

public class Boj_2563 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int[][] map = new int[101][101];
    static int N, ans;

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            for (int row = y; row < y + 10; row++) {
                for (int col = x; col < x + 10; col++) {
                    map[row][col] = 1;
                }
            }
        }

        for (int y = 1; y <= 100; y++) {
            for (int x = 1; x <= 100; x++) {
                if (map[y][x] == 1) {
                    ans++;
                }
            }
        }

        System.out.println(ans);
    }
}
