import java.io.*;
import java.util.*;

public class Boj_14675 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static List<Integer>[] tree;
    static int N, q;
    static final int CUT_VERTEX = 1;
    static final int CUT_BIRDGE = 2;

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        tree = new ArrayList[N + 1];
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

        q = Integer.parseInt(br.readLine());
        for (int i = 1; i <= q; i++) {
            st = new StringTokenizer(br.readLine());
            int option = Integer.parseInt(st.nextToken());
            int target = Integer.parseInt(st.nextToken());
            if (option == CUT_VERTEX) {
                if (tree[target].size() > 1) {
                    sb.append("yes");
                } else {
                    sb.append("no");
                }
            } else {
                sb.append("yes");
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }
}
