import java.io.*;
import java.util.*;

public class Boj_2828 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int N, M, J, left, right, ans;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        J = Integer.parseInt(br.readLine());

        right = M;
        left = 1;
        for (int i = 1; i <= J; i++) {
            int now = Integer.parseInt(br.readLine());
            if (left <= now && now <= right) {
                continue;
            }
            if (left > now) {
                int movement = left - now;
                ans += movement;
                left = now;
                right -= movement;
                continue;
            }
            int movement = now - right;
            ans += movement;
            right = now;
            left += movement;
        }

        System.out.println(ans);
    }
}
