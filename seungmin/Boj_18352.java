import java.util.*;
import java.io.*;

public class Boj_18352 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static List<Integer>[] graph;
    static int[] dist;
    static int N, M, K, X;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());

        graph = new ArrayList[N + 1];
        dist = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
            dist[i] = Integer.MAX_VALUE;
        }

        for (int i = 1; i <= M; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            graph[from].add(to);
        }

        bfs(X);
        for(int i = 1; i <= N; i++){
            if(dist[i] == K){
                sb.append(i).append("\n");
            }
        }
        if(sb.length() == 0){
            System.out.println(-1);
        }else
            System.out.println(sb);
    }

    static void bfs(int start){
        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        dist[start] = 0;
        while(!q.isEmpty()){
            int now = q.poll();
            for(int next : graph[now]){
                if(dist[next] > dist[now] + 1){
                    dist[next] = dist[now] + 1;
                    q.add(next);
                }
            }
        }
    }
}
