import java.io.*;
import java.util.*;

public class SWEA_2070 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static int T;

    public static void main(String[] args) throws IOException {
        T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            sb.append("#").append(t).append(" ");
            if (from == to) {
                sb.append("=");
            } else if (from > to) {
                sb.append(">");
            } else {
                sb.append("<");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}
