import java.io.*;
import java.util.*;

public class Boj_14621 {
    static class Uni {
        int from, to, cost;

        Uni(int from, int to, int cost) {
            this.from = from;
            this.to = to;
            this.cost = cost;
        }
    }

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static List<Uni> unis = new ArrayList<>();
    static String types;
    static boolean[] visited;
    static int[] parent;
    static int N, M, ans;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        types = br.readLine().replaceAll(" ", "");

        parent = new int[N + 1];
        visited = new boolean[N + 1];
        for (int i = 1; i <= N; i++) {
            parent[i] = i;
        }

        for (int i = 1; i <= M; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            if (types.charAt(from - 1) == types.charAt(to - 1)) {
                continue;
            }
            unis.add(new Uni(from, to, cost));
        }

        Collections.sort(unis, (u1, u2) -> u1.cost - u2.cost);

        for (Uni uni : unis) {
            if (find(uni.from) == find(uni.to)) {
                continue;
            }

            union(uni.from, uni.to);
            ans += uni.cost;
        }

        int cnt = 0;
        for (int i = 1; i <= N; i++) {
            if (i == parent[i]) {
                cnt++;
            }
        }

        if (cnt > 1) {
            System.out.println(-1);
            return;
        }

        System.out.println(ans);
    }

    static int find(int num) {
        if (num == parent[num]) {
            return num;
        }

        return parent[num] = find(parent[num]);
    }

    static void union(int from, int to) {
        parent[find(to)] = find(from);
    }
}
