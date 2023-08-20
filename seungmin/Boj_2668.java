import java.io.*;
import java.util.*;

public class Boj_2668 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static List<Integer> ans = new ArrayList<>();
    static boolean[] visited, isCycled;
    static int[] numbers;
    static int N;

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());

        numbers = new int[N + 1];
        visited = new boolean[N + 1];
        isCycled = new boolean[N + 1];

        for (int idx = 1; idx <= N; idx++) {
            int target = Integer.parseInt(br.readLine());
            numbers[idx] = target;
        }

        for (int i = 1; i <= N; i++) {
            visited = new boolean[N + 1];
            dfs(i, i);
        }

        int cnt = ans.size();

        sb.append(cnt).append("\n");
        for (int a : ans) {
            sb.append(a).append("\n");
        }

        System.out.println(sb);
    }

    static void dfs(int now, int root) {
        if (visited[now]) {
            return;
        }
        visited[now] = true;
        int next = numbers[now];
        dfs(next, root);

        if (next == root) {
            ans.add(root);
        }
    }
}
