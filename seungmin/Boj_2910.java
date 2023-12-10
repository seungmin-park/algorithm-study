import java.io.*;
import java.util.*;

public class Boj_2910 {
    static class Num {
        int idx, freq;

        public Num(int idx, int freq) {
            this.idx = idx;
            this.freq = freq;
        }
    }

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static Map<Integer, Num> map = new LinkedHashMap<>();
    static int N, C;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            int target = Integer.parseInt(st.nextToken());
            if (map.get(target) == null) {
                Num num = new Num(i, 0);
                map.put(target, num);
            }
            map.get(target).freq++;
        }

        map.keySet()
                .stream()
                .sorted((k1, k2) -> map.get(k2).freq - map.get(k1).freq)
                .forEach(key -> {
                    Num num = map.get(key);
                    int freq = num.freq;
                    for (int i = 0; i < freq; i++) {
                        sb.append(key).append(" ");
                    }
                });

        System.out.println(sb);
    }
}
