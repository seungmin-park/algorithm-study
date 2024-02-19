import java.io.*;
import java.util.*;

public class Boj_25884 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static Map<String, Integer> schedule = new HashMap<>();
    static int N;

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        for (int i = 1; i <= N; i++) {
            for (int j = 0; j < 4; j++) {
                st = new StringTokenizer(br.readLine());
                for (int day = 0; day < 7; day++) {
                    String name = st.nextToken();
                    if (name.equals("-")) {
                        continue;
                    }
                    if (j == 0) {
                        schedule.put(name, schedule.getOrDefault(name, 0) + 4);
                        continue;
                    }
                    if (j == 1) {
                        schedule.put(name, schedule.getOrDefault(name, 0) + 6);
                        continue;
                    }
                    if (j == 2) {
                        schedule.put(name, schedule.getOrDefault(name, 0) + 4);
                        continue;
                    }
                    schedule.put(name, schedule.getOrDefault(name, 0) + 10);
                }
            }
        }

        for (String pre : schedule.keySet()) {
            for (String post : schedule.keySet()) {
                if (pre.equals(post)) {
                    continue;
                }
                if (12 < Math.abs(schedule.get(pre) - schedule.get(post))) {
                    System.out.println("No");
                    return;
                }
            }
        }

        System.out.println("Yes");
    }
}
