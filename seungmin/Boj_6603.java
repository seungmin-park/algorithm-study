import java.io.*;
import java.util.*;

public class Boj_6603 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static int[] selected = new int[7], numbers;
    static boolean[] isUsed = new boolean[50];
    static int N;

    public static void main(String[] args) throws IOException {
        while(true){
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            if(N == 0) break;
            numbers = new int[N + 1];
            for (int i = 1; i <= N; i++) {
                numbers[i] = Integer.parseInt(st.nextToken());
            }
            func(1);
            sb.append("\n");
        }
        System.out.println(sb);
    }

    static void func(int k) {
        if (k == 7) {
            for (int i = 1; i <= 6; i++) {
                sb.append(selected[i]).append(" ");
            }
            sb.append("\n");
            return;
        }
        for (int i = k; i <= N; i++) {
            if (isUsed[numbers[i]] || selected[k - 1] > numbers[i])
                continue;
            selected[k] = numbers[i];
            isUsed[numbers[i]] = true;
            func(k + 1);
            selected[k] = 0;
            isUsed[numbers[i]] = false;
        }
    }
}
