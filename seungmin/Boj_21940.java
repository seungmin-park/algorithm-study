import java.io.*;
import java.util.*;

public class Boj_21940 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static List<Integer> firends = new ArrayList<>();
    static List<Integer> cand = new ArrayList<>();
    static int[][] map;
    static int N, M, K, min = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N + 1][N + 1];
        for (int i = 1; i <= N; i++) {
            Arrays.fill(map[i], Integer.MAX_VALUE);
            map[i][i] = 0;
        }

        for (int i = 1; i <= M; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int dist = Integer.parseInt(st.nextToken());
            map[from][to] = dist;
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

        K = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= K; i++) {
            firends.add(Integer.parseInt(st.nextToken()));
        }
        for (int i = 1; i <= N; i++) {
            int sum = 0;
            for (int firend : firends) {
                sum = Math.max(sum, map[firend][i] + map[i][firend]);
            }
            if (sum == min) {
                cand.add(i);
                continue;
            }
            if (sum > min) {
                continue;
            }
            if (sum < min) {
                min = sum;
                cand.removeAll(cand);
                cand.add(i);
            }
        }

        Collections.sort(cand);

        for (int c : cand) {
            sb.append(c).append(" ");
        }

        System.out.println(sb);
    }
}
