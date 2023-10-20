import java.io.*;
import java.util.*;

public class Boj_25947 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static boolean[] discounts;
    static long[] arr;
    static int n, b, a, ans;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        b = Integer.parseInt(st.nextToken());
        a = Integer.parseInt(st.nextToken());

        arr = new long[n + 1];
        discounts = new boolean[n + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr, 1, n + 1);
        long sum = 0;
        for (int i = 1; i <= n; i++) {
            if (b - sum >= arr[i]) {
                sum += arr[i];
                ans++;
                continue;
            }
            boolean flag = false;
            for (int j = i; j > 0; j--) {
                if (discounts[j]) {
                    continue;
                }
                if (a < 1) {
                    break;
                }
                sum -= arr[j] / 2;
                a--;
                discounts[j] = true;
                if (b - sum >= arr[i]) {
                    flag = true;
                    sum += arr[i];
                    ans++;
                    break;
                }
            }
            if (!flag) {
                break;
            }
        }

        System.out.println(ans);
    }
}
