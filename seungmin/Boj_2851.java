import java.io.*;

public class Boj_2851 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int[] arr = new int[10], sum = new int[10];
    static int ans, differ = Integer.MAX_VALUE;
    static final int STANDARD = 100;

    public static void main(String[] args) throws IOException {
        for (int i = 0; i < 10; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        sum[0] = arr[0];
        for (int i = 1; i < 10; i++) {
            sum[i] = sum[i - 1] + arr[i];
        }

        for (int i = 0; i < 10; i++) {
            if (differ >= Math.abs(STANDARD - sum[i])) {
                ans = sum[i];
                differ = Math.abs(STANDARD - sum[i]);
            }
        }

        System.out.println(ans);
    }
}
