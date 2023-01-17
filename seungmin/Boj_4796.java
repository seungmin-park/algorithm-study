import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_4796 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    static int P, L, V;

    public static void main(String[] args) throws IOException {
        int repeat = 1;
        while (true) {
            st = new StringTokenizer(br.readLine());
            L = Integer.parseInt(st.nextToken());
            P = Integer.parseInt(st.nextToken());
            V = Integer.parseInt(st.nextToken());
            if (L == 0 && P == 0 && V == 0) {
                break;
            }
            sb.append("Case ")
                    .append(repeat)
                    .append(": ");
            if (V % P <= L) {
                sb.append(V / P * L + V % P);
            } else {
                sb.append(V / P * L + L);
            }
            sb.append("\n");
            repeat++;
        }
        System.out.print(sb);
    }
}
