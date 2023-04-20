import java.io.*;
import java.util.*;

public class Boj_2660 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static int[][] graph;
    static List<Integer> cands = new ArrayList<>();
    static int N, candPoint = Integer.MAX_VALUE, candCnt;

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        graph = new int[N + 1][N + 1];

        for (int col = 1; col <= N; col++) {
            for (int row = 1; row <= N; row++) {
                if (col == row) {
                    graph[col][row] = 0;
                    continue;
                }
                graph[col][row] = Integer.MAX_VALUE;
            }
        }

        while (true) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            if (from == -1 && to == -1)
                break;
            graph[from][to] = 1;
            graph[to][from] = 1;
        }

        for (int k = 1; k <= N; k++) {
            for (int a = 1; a <= N; a++) {
                for (int b = 1; b <= N; b++) {
                    if (graph[a][k] == Integer.MAX_VALUE || graph[k][b] == Integer.MAX_VALUE)
                        continue;
                    graph[a][b] = Math.min(graph[a][b], graph[a][k] + graph[k][b]);
                }
            }
        }
        for (int col = 1; col <= N; col++) {
            int point = 0;
            for (int row = 1; row <= N; row++) {
                point = Math.max(point, graph[col][row]);
            }
            candPoint = Math.min(candPoint, point);
        }

        sb.append(candPoint).append(" ");

        for (int col = 1; col <= N; col++) {
            int point = 0;
            for (int row = 1; row <= N; row++) {
                point = Math.max(point, graph[col][row]);
            }
            if (candPoint == point) {
                cands.add(col);
            }
        }
        sb.append(cands.size()).append("\n");

        for (int cand : cands) {
            sb.append(cand).append(" ");
        }

        System.out.println(sb);
    }
}
