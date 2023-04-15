import java.io.*;
import java.util.*;

public class Boj_2210 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb;
    static StringTokenizer st;
    static Set<String> numbers = new HashSet<>();
    static int[][] dir = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };
    static int[][] graph = new int[5 + 1][5 + 1];
    static int[] checked = new int[5 + 1];

    public static void main(String[] args) throws IOException {
        for (int col = 1; col <= 5; col++) {
            st = new StringTokenizer(br.readLine());
            for (int row = 1; row <= 5; row++) {
                graph[col][row] = Integer.parseInt(st.nextToken());
            }
        }

        for (int col = 1; col <= 5; col++) {
            for (int row = 1; row <= 5; row++) {
                bfs(col, row, 0);
            }
        }

        System.out.println(numbers.size());
    }

    static void bfs(int col, int row, int depth) {
        checked[depth] = graph[col][row];
        if (depth == 5) {
            sb = new StringBuilder();
            for (int i = 0; i < 6; i++) {
                sb.append(checked[i]);
            }
            numbers.add(sb.toString());
            return;
        }
        for (int i = 0; i < 4; i++) {
            int dy = col + dir[i][0];
            int dx = row + dir[i][1];
            if (dy < 1 || dy > 5 || dx < 1 || dx > 5)
                continue;
            bfs(dy, dx, depth + 1);
        }
    }
}
