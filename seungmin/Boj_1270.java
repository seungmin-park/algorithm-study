import java.io.*;
import java.util.*;

public class Boj_1270 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static Map<Long, Integer> map;
    static int N;

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        for (int i = 1; i <= N; i++) {
            map = new HashMap<>();
            st = new StringTokenizer(br.readLine());
            int cnt = Integer.parseInt(st.nextToken());
            for (int j = 1; j <= cnt; j++) {
                long target = Long.parseLong(st.nextToken());
                map.put(target, map.getOrDefault(target, 0) + 1);
            }

            long k = -1;
            int max = Integer.MIN_VALUE;
            for (long key : map.keySet()) {
                if (map.get(key) > max) {
                    k = key;
                    max = map.get(key);
                }
            }

            if (max > cnt / 2) {
                sb.append(k).append("\n");
            } else {
                sb.append("SYJKGW").append("\n");
            }
        }

        System.out.println(sb);
    }
}
