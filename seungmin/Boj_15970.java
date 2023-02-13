import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class Boj_15970 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int N, ans;
    static Map<Integer, List<Integer>> points = new HashMap<>();

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int loc = Integer.parseInt(st.nextToken());
            int color = Integer.parseInt(st.nextToken());
            points.computeIfAbsent(color, k -> new ArrayList<>());
            points.get(color).add(loc);
        }

        for (Integer color : points.keySet()) {
            Collections.sort(points.get(color));
        }

        for (Integer color : points.keySet()) {
            int perColorCnt = points.get(color).size();
            ans += points.get(color).get(1) - points.get(color).get(0);
            ans += points.get(color).get(perColorCnt - 1) - points.get(color).get(perColorCnt - 2);

            for (int i = 1; i < perColorCnt - 1; i++) {
                int leftDistance = points.get(color).get(i) - points.get(color).get(i - 1);
                int rightDistance = points.get(color).get(i + 1) - points.get(color).get(i);
                ans += Math.min(leftDistance, rightDistance);
            }
        }

        System.out.println(ans);
    }
}
