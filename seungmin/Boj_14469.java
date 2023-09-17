import java.io.*;
import java.util.*;

public class Boj_14469 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static List<int[]> l = new ArrayList<>();
    static int N, ans;

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            l.add(new int[] { start, end });
        }

        Collections.sort(l, (e1, e2) -> e1[0] - e2[0]);

        for (int[] e : l) {
            int start = e[0];
            int end = e[1];
            if (start > ans) {
                ans += (start - ans);
            }
            ans += end;
        }

        System.out.println(ans);
    }
}
