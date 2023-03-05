import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Boj_24480 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static boolean visit[];
    static ArrayList<Integer>[] graph;
    static int N, M, R, depth;
    static int[] dist;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        dist = new int[N + 1];
        graph = new ArrayList[N + 1];
        visit = new boolean[N + 1];

        for(int i = 1; i <=N; i++){
            graph[i] = new ArrayList<>();
        }

        for(int i =1 ; i<= M; i++){
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            graph[from].add(to);
            graph[to].add(from);
        }

        for(int i =1; i <=N; i++){
            graph[i].sort(Collections.reverseOrder());
        }
        dfs(R);
        for(int i = 1; i<=N; i++){
            System.out.println(dist[i]);
        }
    }

    static void dfs(int start){
        visit[start] = true;
        dist[start] = ++depth;
        for(int next : graph[start]){
            if(visit[next]){
                continue;
            }
            dfs(next);
        }
    }
}
