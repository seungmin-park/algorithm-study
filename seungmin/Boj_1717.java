import java.io.*;
import java.util.*;

public class Boj_1717 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static int[] parents;
    static int N, M;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        parents = new int[N + 1];

        for (int i = 0; i <= N; i++) {
            parents[i] = i;
        }

        for (int i = 1; i <= M; i++) {
            st = new StringTokenizer(br.readLine());
            String option = st.nextToken();
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            if (option.equals("1")) {
                if (find(from) == find(to)) {
                    sb.append("YES");
                } else {
                    sb.append("NO");
                }
                sb.append("\n");
                continue;
            }

            union(from, to);
        }

        System.out.println(sb);
    }

    static int find(int num) {
        if (num == parents[num]) {
            return parents[num];
        }

        return parents[num] = find(parents[num]);
    }

    static void union(int from, int to) {
        int fromParent = find(from);
        int toParent = find(to);
        if (fromParent == toParent) {
            return;
        }

        parents[toParent] = fromParent;
    }
}
