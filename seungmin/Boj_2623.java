import java.io.*;
import java.util.*;

/**
 * 틀렸던 이유: '순서를 정하는 것이 불가능할 경우에는 첫째 줄에 0을 출력한다.'을 고려하지 않음
 */
public class Boj_2623 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static List<Integer>[] graph;
    static List<Integer> ans = new ArrayList<>();
    static int[] indeg;
    static int N, M;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        graph = new ArrayList[N + 1];
        indeg = new int[N + 1];

        for(int i = 1; i <= N; i++){
            graph[i] = new ArrayList<>();
        }

        for(int i = 1; i <= M; i++){
            st = new StringTokenizer(br.readLine());
            int cnt = Integer.parseInt(st.nextToken());
            int from = Integer.parseInt(st.nextToken());
            for(int j = 1; j < cnt; j++){
                int to = Integer.parseInt(st.nextToken());
                graph[from].add(to);
                indeg[to]++;
                from = to;
            }
        }

        bfs();
        if(ans.size() != N){
            System.out.println(0);
            return;
        }
        for(int a : ans){
            sb.append(a).append("\n");
        }
        System.out.println(sb);
    }

    static void bfs(){
        Queue<Integer> q = new LinkedList<>();
        for(int i = 1; i <=N; i++){
            if(indeg[i] == 0) q.add(i);
        }

        while(!q.isEmpty()){
            int now = q.poll();
            ans.add(now);
            for(int next : graph[now]){
                indeg[next]--;
                if(indeg[next] == 0){
                    q.add(next);
                }
            }
        }
    }
}
