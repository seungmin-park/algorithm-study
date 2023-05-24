import java.io.*;
import java.util.*;

public class Boj_1026 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int[] A, B;
    static int N, ans;

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        A = new int[N];
        B = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            B[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(A);
        Arrays.sort(B);

        for (int i = 0; i < N; i++) {
            ans += (A[i] * B[N - i - 1]);
        }

        System.out.println(ans);
    }
}
