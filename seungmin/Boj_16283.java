import java.io.*;
import java.util.*;

public class Boj_16283 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static int[] sheep, goat;
    static int a, b, n, w, sheepCnt, goatCnt, cand;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        a = Integer.parseInt(st.nextToken());
        b = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        w = Integer.parseInt(st.nextToken());

        sheep = new int[n + 1];
        goat = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            sheep[i] = a * i;
            goat[i] = b * i;
        }

        for (int i = 1; i < n; i++) {
            if (sheep[i] + goat[n - i] == w) {
                cand++;
                sheepCnt = i;
                goatCnt = n - i;
            }
        }

        if (cand == 1) {
            System.out.println(sb.append(sheepCnt).append(" ").append(goatCnt));
        } else {
            System.out.println(-1);
        }
    }
}
