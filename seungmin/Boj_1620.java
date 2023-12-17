import java.io.*;
import java.util.*;

public class Boj_1620 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static Map<Integer, String> dic = new HashMap<>();
    static Map<String, Integer> dicReverse = new HashMap<>();
    static int N, M;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        for (int i = 1; i <= N; i++) {
            String target = br.readLine();
            dic.put(i, target);
            dicReverse.put(target, i);
        }

        for (int i = 1; i <= M; i++) {
            String target = br.readLine();
            if (Character.isDigit(target.charAt(0))) {
                sb.append(dic.get(Integer.parseInt(target))).append("\n");
                continue;
            }

            Integer num = dicReverse.get(target);
            sb.append(num).append("\n");
        }

        System.out.println(sb);
    }
}
