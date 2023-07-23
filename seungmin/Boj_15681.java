import java.io.*;
import java.util.*;

public class Boj_15681 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static List<Integer>[] tree;
    static int[] dp;
    static int N, R, U;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
        U = Integer.parseInt(st.nextToken());

        tree = new ArrayList[N + 1];
        dp = new int[N + 1];
        for(int i =1 ; i <= N; i++){
            tree[i] = new ArrayList<>();
            dp[i] = 1;
        }

        for(int i = 1; i < N; i++){
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            tree[from].add(to);
            tree[to].add(from);
        }

        dfs(R, -1);
        for(int i = 1; i <= U; i++){
            sb.append(dp[Integer.parseInt(br.readLine())]).append("\n");
        }

        System.out.println(sb);
    }

    static void dfs(int now, int parent){
        for(int child : tree[now]){
            if(parent == child){
                continue;
            }
            dfs(child, now);
            dp[now] += dp[child];
        }
    }
}
