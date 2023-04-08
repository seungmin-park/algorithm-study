import java.io.*;
import java.util.*;

public class Boj_1766 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static List<Integer>[] math;
    static List<Integer> preProblems = new ArrayList<>();
    static int[] indeg;
    static int N, M;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        math = new ArrayList[N + 1];
        indeg = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            math[i] = new ArrayList<>();
        }

        for (int i = 1; i <= M; i++) {
            st = new StringTokenizer(br.readLine());

            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());

            math[from].add(to);
            indeg[to]++;
        }

        bfs();
        System.out.println(sb);
    }

    static void bfs() {
        PriorityQueue<Integer> q = new PriorityQueue<>();
        for (int i = 1; i <= N; i++) {
            Collections.sort(math[i]);
            if (indeg[i] == 0) {
                q.add(i);
            }
        }

        while (!q.isEmpty()) {
            int now = q.poll();
            sb.append(now).append(" ");
            for (int next : math[now]) {
                indeg[next]--;
                if (indeg[next] == 0) {
                    q.add(next);
                }
            }
        }
    }
}
