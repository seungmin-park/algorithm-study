import java.io.*;
import java.util.*;

public class Boj_1158 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static List<Integer> list = new ArrayList<>();
    static int N, K;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        for (int i = 1; i <= N; i++) {
            list.add(i);
        }

        int idx = K - 1;
        sb.append("<").append(list.remove(idx));
        while (list.size() != 0) {
            idx = (idx + (K - 1)) % list.size();
            sb.append(", ").append(list.remove(idx));
        }
        sb.append(">");

        System.out.println(sb);
    }
}
