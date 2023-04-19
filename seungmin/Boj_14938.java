import java.io.*;
import java.util.*;

public class Boj_14938 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int[][] graph;
    static int[] itemCnt;
    static int n, m, r, ans;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());

        itemCnt = new int[n + 1];
        graph = new int[n + 1][n + 1];

        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= n; j++){
                if(i == j) continue;
                graph[i][j] = Integer.MAX_VALUE;
            }
        }

        st = new StringTokenizer(br.readLine());
        for(int i =1; i <= n; i++){
            itemCnt[i] = Integer.parseInt(st.nextToken());
        }
        for(int i = 1; i <= r; i++){
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            graph[from][to] = weight;
            graph[to][from] = weight;
        }

        for(int k = 1; k <= n; k++){
            for(int a = 1; a <= n; a++){
                for(int b = 1; b <= n; b++){
                    if(graph[a][k] == Integer.MAX_VALUE || graph[k][b] == Integer.MAX_VALUE) continue;
                    graph[a][b] = Math.min(graph[a][b], graph[a][k] + graph[k][b]);
                }
            }
        }

        for(int i =1; i <= n; i++){
            int sum = 0;
            for(int j = 1; j <= n; j++){
                if(graph[i][j] > m) continue;
                sum += itemCnt[j];
            }

            ans = Math.max(ans, sum);
        }

        System.out.println(ans);
    }
}
