import java.io.*;
import java.util.*;

public class Boj_21921 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static int[] arr;
    static int X, N, max, cnt = 1;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());

        arr = new int[N + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            if (i <= X) {
                max += arr[i];
            }
        }

        int temp = max;
        for (int x = X + 1; x <= N; x++) {
            temp = temp - arr[x - X] + arr[x];
            if (temp < max) {
                continue;
            }
            if (temp == max) {
                cnt++;
                continue;
            }
            if (temp > max) {
                cnt = 1;
                max = temp;
            }
        }
        if (max == 0) {
            System.out.println("SAD");
            return;
        }
        sb.append(max).append("\n").append(cnt);
        System.out.println(sb);
    }
}
