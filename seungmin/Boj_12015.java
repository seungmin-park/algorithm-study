import java.util.*;
import java.io.*;

public class Boj_12015 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int[] LIS;
    static int N, ans = 1;

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        LIS = new int[N + 1];

        st = new StringTokenizer(br.readLine());
        LIS[0] = Integer.parseInt(st.nextToken());

        for (int i = 1; i < N; i++) {
            int now = Integer.parseInt(st.nextToken());
            if (LIS[ans - 1] < now) {
                LIS[ans] = now;
                ans++;
            } else {
                LIS[lowerBound(0, ans - 1, now)] = now;
            }
        }

        System.out.println(ans);
    }

    static int lowerBound(int L, int R, int target) {
        while (L < R) {
            int M = (L + R) / 2;
            if(LIS[M] < target){
                L = M + 1;
            }else{
                R = M;
            }
        }

        return L;
    }
}
