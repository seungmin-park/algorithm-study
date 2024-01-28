import java.io.*;
import java.math.BigDecimal;
import java.util.*;

public class Boj_2870 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static List<BigDecimal> list = new ArrayList<>();
    static int N;

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        for (int i = 1; i <= N; i++) {
            StringBuilder buffer = new StringBuilder();
            String target = br.readLine();
            for (int j = 0; j < target.length(); j++) {
                if ('0' <= target.charAt(j) && target.charAt(j) <= '9') {
                    buffer.append(target.charAt(j));
                    continue;
                }
                if (buffer.length() == 0) {
                    continue;
                }
                list.add(new BigDecimal(buffer.toString()));
                buffer = new StringBuilder();
            }
            if (buffer.length() == 0) {
                continue;
            }
            list.add(new BigDecimal(buffer.toString()));
        }

        Collections.sort(list);
        for (BigDecimal bigDecimal : list) {
            sb.append(bigDecimal.toString()).append("\n");
        }

        System.out.println(sb);
    }
}

