import java.io.*;
import java.util.*;

/**
 * 오답 예외 케이스
 * 5 5
 * 0 1
 * 1 2
 * 2 3
 * 3 0
 * 1 4
 */
public class Boj_13023 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static List<Integer>[] relationship;
    static boolean[] visited;
    static int N, M, ans;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        relationship = new ArrayList[N + 1];
        visited = new boolean[N + 1];

        for (int i = 0; i < N; i++) {
            relationship[i] = new ArrayList<>();
        }

        for (int i = 1; i <= M; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            relationship[from].add(to);
            relationship[to].add(from);
        }

        for (int i = 0; i < N; i++) {
            if (ans == 1) {
                break;
            }
            func(i, 1);
        }

        System.out.println(ans);
    }

    static void func(int now, int depth) {
        if (depth > 4) {
            ans = 1;
            return;
        }
        visited[now] = true;

        for (int next : relationship[now]) {
            if (visited[next]) {
                continue;
            }
            func(next, depth + 1);
        }
        visited[now] = false;
    }
}
