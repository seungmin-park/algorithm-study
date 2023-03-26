import java.io.*;
import java.util.*;

public class Boj_18511 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int[] numbers, selected;
    static int N, K, cnt, ans;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        int length = String.valueOf(N).length();
        numbers = new int[K + 1];
        selected = new int[length + 1];

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= K; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(numbers);
        
        func(1, length);
        func(1, length - 1);

        System.out.println(ans);
    }

    static void func(int k, int idx) {
        if (k == idx + 1) {
            StringBuilder sb = new StringBuilder();
            for (int i = 1; i <= idx; i++) {
                sb.append(selected[i]);
            }
            int temp = Integer.parseInt(sb.toString());
            if(temp <= N){
                ans = Math.max(ans, temp);
            }
            return;
        }

        for (int i = K; i > 0 ; i--) {
            selected[k] = numbers[i];
            func(k + 1, idx);
            selected[k] = 0;
        }
    }
}
