import java.io.*;
import java.util.*;

public class Boj_4195 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static Map<String, Integer> num;
    static int[] parents = new int[200_001];
    static int[] cnt = new int[200_001];
    static int T, F;

    public static void main(String[] args) throws IOException {
        T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            F = Integer.parseInt(br.readLine());
            num = new HashMap<>();
            for (int i = 0; i <= 200_000; i++) {
                parents[i] = i;
                cnt[i] = 1;
            }
            int number = 0;
            for (int i = 1; i <= F; i++) {
                st = new StringTokenizer(br.readLine());
                String from = st.nextToken();
                String to = st.nextToken();
                if (!num.containsKey(from)) {
                    num.put(from, number);
                    number++;
                }
                if (!num.containsKey(to)) {
                    num.put(to, number);
                    number++;
                }

                int fromParent = find(num.get(from));
                int toParent = find(num.get(to));
                if (fromParent == toParent) {
                    sb.append(cnt[fromParent]).append("\n");
                    continue;
                }

                cnt[fromParent] += cnt[toParent];
                cnt[toParent] = cnt[fromParent];
                sb.append(cnt[fromParent]).append("\n");
                union(fromParent, toParent);
            }
        }

        System.out.println(sb);
    }

    static int find(int num) {
        if (num == parents[num]) {
            return parents[num];
        }
        return parents[num] = find(parents[num]);
    }

    static void union(int fromParent, int toParent) {
        parents[toParent] = parents[fromParent];
    }
}
