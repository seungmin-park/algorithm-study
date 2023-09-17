import java.io.*;
import java.util.*;

public class Boj_25601 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static Map<String, List<String>> rel = new HashMap<>();
    static int N;

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        for (int i = 1; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            String child = st.nextToken();
            String parent = st.nextToken();
            if (!rel.containsKey(parent)) {
                rel.put(parent, new ArrayList<>());
            }
            rel.get(parent).add(child);
        }

        st = new StringTokenizer(br.readLine());
        String target1 = st.nextToken();
        String target2 = st.nextToken();

        System.out.println(bfs(target1, target2) || bfs(target2, target1) ? 1 : 0);

    }

    static boolean bfs(String target1, String target2) {
        if (target1.equals(target2)) {
            return true;
        }

        if (rel.get(target1) == null) {
            return false;
        }

        for (String next : rel.get(target1)) {
            if (bfs(next, target2)) {
                return true;
            }
        }

        return false;
    }
}
