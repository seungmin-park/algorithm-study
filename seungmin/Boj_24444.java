import java.io.*;
import java.util.*;

public class Boj_24444 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static ArrayList<Integer>[] graph;
    static boolean[] visit;
    static int[] dist;
    static int N, M, R, depth = 1;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        visit = new boolean[N + 1];
        dist = new int[N + 1];
        graph = new ArrayList[N + 1];
        for(int i = 1; i <=N; i++){
            graph[i] = new ArrayList<>();
        }

        for(int i =1; i <=M; i++){
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            graph[from].add(to);
            graph[to].add(from);
        }

        for(int i = 1; i <= N; i++){
            Collections.sort(graph[i]);
        }

        bfs(R);
        for(int i = 1; i <=N; i++){
            sb.append(dist[i]).append("\n");
        }

        System.out.println(sb.toString());
    }

    static void bfs(int start){
        Queue<Integer> q= new LinkedList<>();
        q.add(start);
        visit[start] = true;
        dist[start] = depth;

        while(!q.isEmpty()){
            int now = q.poll();
            for(int next : graph[now]){
                if(visit[next]) continue;
                q.add(next);
                visit[next] = true;
                dist[next] = ++depth;
            }
        }

    }
}
