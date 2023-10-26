import java.io.*;
import java.util.*;

public class Boj_17203 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static int[] arr;
    static int N, M;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[N + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        for (int m = 1; m <= M; m++) {
            st = new StringTokenizer(br.readLine());
            int ans = 0;
            int to = Integer.parseInt(st.nextToken());
            int from = Integer.parseInt(st.nextToken());
            while (to != from) {
                ans += Math.abs(arr[to + 1] - arr[to]);
                to++;
            }
            sb.append(ans).append("\n");
        }

        System.out.println(sb);
    }
}
