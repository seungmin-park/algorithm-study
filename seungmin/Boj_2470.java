import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 정답 최대치 : -20억 ~ 20억 -> int
 * 1. 완전 탐색: O(N^2) -> 100억 -> X
 * 2. 정렬: O(NlogN): 500,000
 * 2-1: 투 포인터 탐색: O(N): 100,000
 */
public class Boj_2470 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static int[] ans = new int[2];
    static int[] liquids;
    static int N;

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        liquids = new int[N];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++){
            liquids[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(liquids);

        int L = 0;
        int R = N - 1;
        int standard = Integer.MAX_VALUE;
        while (L < R) {
            int sum = liquids[L] + liquids[R];

            if (standard >= Math.abs(sum)) {
                standard = Math.abs(sum);
                ans[0] = liquids[L];
                ans[1] = liquids[R];
            }
            if (sum < 0) {
                L++;
            } else {
                R--;
            }
        }
        sb.append(ans[0]).append(" ").append(ans[1]);
        System.out.println(sb);
    }
}
