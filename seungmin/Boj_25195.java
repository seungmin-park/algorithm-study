import java.io.*;
import java.util.*;

public class Boj_25195 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static boolean[] located;
    static boolean ans;
    static List<Integer>[] graph;
    static int N, M, S;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        located = new boolean[N + 1];
        graph = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 1; i <= M; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            graph[from].add(to);
        }

        S = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= S; i++) {
            located[Integer.parseInt(st.nextToken())] = true;
        }
        dfs(1);
        if (ans) {
            System.out.println("Yes1");
            return;
        }
        System.out.println("yes2");
    }

    static void dfs(int cur) {
        if (ans || located[cur])
            return;
        if (graph[cur].size() == 0) {
            ans = true;
            return;
        }
        for (Integer next : graph[cur])
            dfs(next);
    }
}
