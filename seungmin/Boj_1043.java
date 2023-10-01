import java.io.*;
import java.util.*;

public class Boj_1043 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static List<Integer>[] graph;
    static List<Integer> lier = new ArrayList<>();
    static String[] cands;
    static boolean[] visited;
    static int[] parents;
    static int N, M, ans;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        ans = M;

        parents = new int[N + 1];
        visited = new boolean[N + 1];
        cands = new String[M + 1];
        graph = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            parents[i] = i;
            graph[i] = new ArrayList<>();
        }
        st = new StringTokenizer(br.readLine());
        int cnt = Integer.parseInt(st.nextToken());
        if (cnt != 0) {
            while (st.hasMoreTokens()) {
                lier.add(Integer.parseInt(st.nextToken()));
            }

            for (int i = 1; i <= M; i++) {
                cands[i] = br.readLine();
                st = new StringTokenizer(cands[i]);
                int peopleCnt = Integer.parseInt(st.nextToken());
                if (peopleCnt == 1) {
                    continue;
                }
                int stand = Integer.parseInt(st.nextToken());
                int parent = find(stand);
                while (st.hasMoreTokens()) {
                    int target = Integer.parseInt(st.nextToken());
                    int targetParent = find(target);
                    parents[targetParent] = parent;
                }
            }

            for (int i = 1; i <= N; i++) {
                if (parents[i] == i) {
                    continue;
                }
                graph[i].add(parents[i]);
                graph[parents[i]].add(i);
            }

            for (int i : lier) {
                bfs(i);
            }

            for (int i = 1; i <= M; i++) {
                st = new StringTokenizer(cands[i]);
                int pCnt = Integer.parseInt(st.nextToken());
                for (int j = 1; j <= pCnt; j++) {
                    int target = Integer.parseInt(st.nextToken());
                    if (visited[target]) {
                        ans--;
                        break;
                    }
                }
            }

            System.out.println(ans);
        } else {
            for (int i = 1; i <= M; i++) {
                br.readLine();
            }
            System.out.println(M);
        }
    }

    static int find(int num) {
        if (parents[num] == num) {
            return num;
        }
        return parents[num] = find(parents[num]);
    }

    static void bfs(int start) {
        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        visited[start] = true;

        while (!q.isEmpty()) {
            int now = q.poll();
            for (int next : graph[now]) {
                if (visited[next]) {
                    continue;
                }
                visited[next] = true;
                q.add(next);
            }
        }
    }
}