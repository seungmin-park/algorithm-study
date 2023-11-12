import java.io.*;
import java.util.*;

public class Boj_9093 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    static int T;

    public static void main(String[] args) throws IOException {
        T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            st = new StringTokenizer(br.readLine());
            while(st.hasMoreTokens()){
                StringBuffer target = new StringBuffer(st.nextToken());
                sb.append(target.reverse()).append(" ");
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }
}
