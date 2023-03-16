import java.io.*;
import java.util.*;

public class Boj_11403 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static int[][] graph;
    static boolean[] visited;
    static boolean[][] answer;
    static int N;

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        graph = new int[N + 1][N + 1];
        visited = new boolean[N + 1];
        answer = new boolean[N + 1][N + 1];

        for (int col = 1; col <= N; col++) {
            st = new StringTokenizer(br.readLine());
            for (int row = 1; row <= N; row++) {
                graph[col][row] = Integer.parseInt(st.nextToken());
            }
        }


        for (int col = 1; col <= N; col++) {
            bfs(col);
            Arrays.fill(visited, false);
        }
        
        for(int col = 1; col <= N; col++){
            for(int row = 1; row <= N; row++){
                sb.append(answer[col][row] ? "1" : "0").append(" ");
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }

    static void bfs(int start){
        Queue<Integer> q = new LinkedList<>();
        for(int row = 1; row <= N; row++){
            if(graph[start][row] == 1){
                q.add(row);
                answer[start][row] = true;
                visited[row] = true;
            }
        }

        while(!q.isEmpty()){
            int now = q.poll();

            for(int next = 1; next <= N; next++){
                if(visited[next]) continue;
                if(graph[now][next] == 0) continue;
                answer[start][next] = true;
                q.add(next);
                visited[next] = true;
            }
        }
    }
}
