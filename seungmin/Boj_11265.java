import java.io.*;
import java.util.*;

public class Boj_11265 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static final String ENJOY = "Enjoy other party";
    static final String STAY = "Stay here";
    static int[][] graph;
    static int N, M;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        graph = new int[N + 1][N + 1];

        for (int col = 1; col <= N; col++) {
            st = new StringTokenizer(br.readLine());
            for (int row = 1; row <= N; row++) {
                graph[col][row] = Integer.parseInt(st.nextToken());
            }
        }

        for (int a = 1; a <= N; a++) {
            for (int b = 1; b <= N; b++) {
                for (int c = 1; c <= N; c++) {
                    graph[b][c] = Math.min(graph[b][c], graph[b][a] + graph[a][c]);
                }
            }
        }

        for (int i = 1; i <= M; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            if (graph[from][to] > weight)
                sb.append(STAY);
            else
                sb.append(ENJOY);
            sb.append("\n");
        }

        System.out.println(sb);
    }
}