import java.io.*;
import java.util.*;

public class Boj_2961 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static boolean[] isUsed;
    static int[][] selected;
    static int[][] taste; 
    static int N, ans = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        taste = new int[N][2];
        isUsed = new boolean[N];

        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            taste[i][0] = Integer.parseInt(st.nextToken());
            taste[i][1] = Integer.parseInt(st.nextToken());
        }

        for(int i = 1; i <= N; i++){
            selected = new int[i][2];
            func(0, i);
        }

        System.out.println(ans);
    }

    static void func(int k, int cnt){
        if(k == cnt){
            int S = selected[0][0];
            int R = selected[0][1];
            for(int i = 1; i < k; i++){
                S *= selected[i][0];
                R += selected[i][1];
            }
            ans = Math.min(ans, Math.abs(S - R));
            return;
        }

        for(int i = k; i < N; i++){
            if(isUsed[i]) continue;
            selected[k][0] = taste[i][0];
            selected[k][1] = taste[i][1];
            isUsed[i] = true;
            func(k + 1, cnt);
            selected[k][0] = 0;
            selected[k][1] = 0;
            isUsed[i] = false;
        }
    }
}
