import java.io.*;
import java.util.*;

public class Boj_10159 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static int[][] graph;
    static int N, M;

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());

        graph = new int[N + 1][N + 1];
        for (int row = 1; row <= N; row++) {
            for (int col = 1; col <= N; col++) {
                graph[row][col] = Integer.MAX_VALUE;
            }
        }

        for (int i = 1; i <= M; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());

            graph[from][to] = 1;
        }

        for (int k = 1; k <= N; k++) {
            for (int from = 1; from <= N; from++) {
                for (int to = 1; to <= N; to++) {
                    if (graph[from][k] == Integer.MAX_VALUE || graph[k][to] == Integer.MAX_VALUE) {
                        continue;
                    }

                    graph[from][to] = Math.min(graph[from][to], graph[from][k] + graph[k][to]);
                }
            }
        }

        for (int row = 1; row <= N; row++) {
            int cnt = 0;
            for (int col = 1; col <= N; col++) {
                if (row == col) {
                    continue;
                }
                if (graph[row][col] != Integer.MAX_VALUE) {
                    cnt++;
                    continue;
                }
                if (graph[col][row] != Integer.MAX_VALUE) {
                    cnt++;
                    continue;
                }
            }
            sb.append(N - 1 - cnt).append("\n");
        }

        System.out.println(sb);
    }
}
