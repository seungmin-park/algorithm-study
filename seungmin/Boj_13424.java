import java.io.*;
import java.util.*;

public class Boj_13424 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static int[][] distances;
    static int T, N, M, K;

    public static void main(String[] args) throws IOException {
        T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());

            distances = new int[N + 1][N + 1];
            for (int i = 1; i <= N; i++) {
                Arrays.fill(distances[i], 9_876_543);
                distances[i][i] = 0;
            }

            for (int i = 1; i <= M; i++) {
                st = new StringTokenizer(br.readLine());
                int from = Integer.parseInt(st.nextToken());
                int to = Integer.parseInt(st.nextToken());
                int dist = Integer.parseInt(st.nextToken());
                distances[from][to] = dist;
                distances[to][from] = dist;
            }

            bfs();

            K = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());
            List<Integer> friends = new ArrayList<>();
            while (st.hasMoreTokens()) {
                friends.add(Integer.parseInt(st.nextToken()));
            }
            int num = -1;
            int dist = Integer.MAX_VALUE;
            for (int i = 1; i <= N; i++) {
                int sum = 0;
                for (int friend : friends) {
                    sum += distances[friend][i];
                }
                if (dist > sum) {
                    num = i;
                    dist = sum;
                }
            }
            sb.append(num).append("\n");
        }
        System.out.println(sb);
    }

    static void bfs() {
        for (int k = 1; k <= N; k++) {
            for (int from = 1; from <= N; from++) {
                for (int to = 1; to <= N; to++) {
                    if (distances[from][k] == 9_876_543 || distances[k][to] == 9_876_543) {
                        continue;
                    }
                    distances[from][to] = Math.min(distances[from][to], distances[from][k] + distances[k][to]);
                }
            }
        }
    }
}
