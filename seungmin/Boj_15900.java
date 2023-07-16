import java.io.*;
import java.util.*;

public class Boj_15900 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static List<Integer>[] tree;
    static int[] parentCnt;
    static int N;

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        tree = new ArrayList[N + 1];
        parentCnt = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            tree[i] = new ArrayList<>();
        }

        for (int i = 1; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            tree[from].add(to);
            tree[to].add(from);
        }

        dfs(1, -1, 0);
        int cnt = 0;
        for (int i = 1; i <= N; i++) {
            cnt += parentCnt[i];
        }

        System.out.println(cnt % 2 == 0 ? "No" : "Yes");
    }

    static void dfs(int start, int parent, int cnt) {
        if (tree[start].size() == 1) {
            parentCnt[start] = cnt;
        }
        for (int child : tree[start]) {
            if (child == parent) {
                continue;
            }
            dfs(child, start, cnt + 1);
        }
    }
}
