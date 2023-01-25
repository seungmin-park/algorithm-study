import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.TreeMap;
import java.util.TreeSet;

public class Boj_2121 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int N, A, B;
    static Map<Integer, Set<Integer>> points = new TreeMap<>();

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine());
        A = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            points.computeIfAbsent(x, k -> new TreeSet<>());
            points.get(x).add(y);
        }

        int result = 0;
        for (Integer x : points.keySet()) {
            if (!points.containsKey(x + A)) {
                continue;
            }
            for (Integer y : points.get(x)) {
                // x, Y + B
                if (!points.get(x).contains(y + B)) {
                    continue;
                }
                // x + A, y
                if (!points.get(x + A).contains(y)) {
                    continue;
                }
                // x + A, y + B
                if (!points.get(x + A).contains(y + B)) {
                    continue;
                }
                result++;
            }
        }

        System.out.println(result);
    }
}
