import java.io.*;
import java.util.*;

public class Boj_21937 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static List<Integer>[] list;
    static boolean[] visited;
    static int N, M;
    static int A, B, X, ans;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        list = new ArrayList[N + 1];
        visited = new boolean[N + 1];

        for (int i = 1; i <= N; i++) {
            list[i] = new ArrayList<>();
        }

        for (int i = 1; i <= M; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            list[to].add(from);
        }

        X = Integer.parseInt(br.readLine());
        dfs(X);
        System.out.println(ans - 1 == -1 ? 0 : ans - 1);
    }

    static void dfs(int start) {
        visited[start] = true;
        ans++;
        for (int next : list[start]) {
            if (visited[next])
                continue;
            dfs(next);
        }
    }
}
