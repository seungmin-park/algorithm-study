import java.io.*;

public class Boj_1058 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int[][] graph, distance;
    static int N, ans = Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        graph = new int[N + 1][N + 1];
        for (int col = 1; col <= N; col++) {
            String next = br.readLine();
            for (int row = 1; row <= N; row++) {
                if (next.charAt(row - 1) == 'N') {
                    graph[col][row] = Integer.MAX_VALUE;
                } else {
                    graph[col][row] = 1;
                }
            }
        }

        for (int k = 1; k <= N; k++) {
            for (int a = 1; a <= N; a++) {
                for (int b = 1; b <= N; b++) {
                    if (graph[a][k] == Integer.MAX_VALUE || graph[k][b] == Integer.MAX_VALUE) {
                        continue;
                    }
                    if (k == a || k == b || a == b) {
                        continue;
                    }
                    graph[a][b] = Math.min(graph[a][b], graph[a][k] + graph[k][b]);
                }
            }
        }

        for (int col = 1; col <= N; col++) {
            int cnt = 0;
            for (int row = 1; row <= N; row++) {
                if (col == row) {
                    continue;
                }
                if (graph[col][row] <= 2 && graph[col][row] != Integer.MAX_VALUE) {
                    cnt++;
                }
            }
            ans = Math.max(ans, cnt);
        }

        System.out.println(ans);
    }
}
