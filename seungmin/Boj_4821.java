import java.io.*;
import java.util.*;

public class Boj_4821 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static Set<Integer> pages;
    static int N;

    public static void main(String[] args) throws IOException {
        while ((N = Integer.parseInt(br.readLine())) != 0) {
            pages = new HashSet<>();
            st = new StringTokenizer(br.readLine(), ",");
            while (st.hasMoreTokens()) {
                String[] range = st.nextToken().split("-");
                int low = Integer.parseInt(range[0]);
                int high;
                if (range.length > 1) {
                    high = Integer.parseInt(range[1]);
                }else {
                    high = low = Integer.parseInt(range[0]);
                }
                if (low > N) {
                    continue;
                }
                if (high > N) {
                    high = N;
                }
                if (low > high) {
                    continue;
                }
                for (int page = low; page <= high; page++) {
                    pages.add(page);
                }
            }

            sb.append(pages.size()).append("\n");
        }

        System.out.println(sb);
    }
}
