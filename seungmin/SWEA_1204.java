import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_1204 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static int[] arr;
    static int T;

    public static void main(String[] args) throws IOException {
        T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            br.readLine();
            arr = new int[101];
            st = new StringTokenizer(br.readLine());
            while (st.hasMoreTokens()) {
                arr[Integer.parseInt(st.nextToken())]++;
            }

            int maxIdx = -1;
            int max = Integer.MIN_VALUE;
            for (int i = 0; i <= 100; i++) {
                if (arr[i] >= max) {
                    max = arr[i];
                    maxIdx = i;
                }
            }
            sb.append("#").append(t).append(" ").append(maxIdx).append("\n");
        }

        System.out.println(sb);
    }
}
