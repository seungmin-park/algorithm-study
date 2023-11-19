import java.io.*;
import java.util.*;

public class SWEA_2071 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static int T;

    public static void main(String[] args) throws IOException {
        T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            st = new StringTokenizer(br.readLine());
            int sum = 0;
            while (st.hasMoreTokens()) {
                sum += Integer.parseInt(st.nextToken());
            }
            double avg = sum / 10.0;

            sb.append("#").append(t).append(" ").append(String.format("%.0f",avg)).append("\n");
        }

        System.out.println(sb);
    }
}
