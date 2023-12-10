import java.io.*;
import java.util.*;

public class Boj_1246 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static int[] arr;
    static int N, M, target, ans = Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[M];
        for (int i = 0; i < M; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(arr);
        for (int left = 0; left < M; left++) {
            int now = arr[left];
            int right = left + N;
            if (right > M) {
                if (ans < now * (M - left)) {
                    ans = now * (M - left);
                    target = now;
                }
                continue;
            }
            if (ans < now * N) {
                ans = now * N;
                target = now;
            }
        }
        sb.append(target).append(" ").append(ans);
        System.out.println(sb);
    }
}
