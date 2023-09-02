import java.io.*;
import java.util.*;

public class Boj_2617 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int[][] map;
    static int N, M, ans;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N + 1][N + 1];

        for (int i = 1; i <= N; i++) {
            Arrays.fill(map[i], Integer.MAX_VALUE);
        }

        for (int i = 1; i <= M; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            map[from][to] = 1;
        }

        for (int k = 1; k <= N; k++) {
            for (int from = 1; from <= N; from++) {
                for (int to = 1; to <= N; to++) {
                    if (map[from][k] == Integer.MAX_VALUE || map[k][to] == Integer.MAX_VALUE) {
                        continue;
                    }
                    map[from][to] = Math.min(map[from][to], map[from][k] + map[k][to]);
                }
            }
        }

        for (int from = 1; from <= N; from++) {
            int cnt = (int) Arrays.stream(map[from])
                    .filter((i) -> i != Integer.MAX_VALUE)
                    .count();
            if (cnt >= ((N + 1) / 2)) {
                ans++;
            }
        }

        for (int from = 1; from <= N; from++) {
            int cnt = 0;
            for (int to = 1; to <= N; to++) {
                if (map[to][from] != Integer.MAX_VALUE) {
                    cnt++;
                }
            }
            if (cnt >= ((N + 1) / 2)) {
                ans++;
            }
        }

        System.out.println(ans);
    }
}
