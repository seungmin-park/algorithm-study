import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 용액의 수 N -> 2 ~ 100,000
 * 1. 완전 탐색 O(N^2): 10^10
 * 2. 양 끝에서 투포인터로 탐색 O(N): 10^5
 * 각 용액의 범위: -10^8 ~ 10^8
 * 계산 최대값 -20억 ~ 20억 -> int
 */
public class Boj_2467 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static int[] liquids;
    static int N, min, max, ans = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        liquids = new int[N + 1];

        st = new StringTokenizer(br.readLine());
        for(int idx = 1; idx <= N; idx++){
            liquids[idx] = Integer.parseInt(st.nextToken());
        }

        int L = 1;
        int R = N;

        while(L < R){
            int sum = liquids[L] + liquids[R];
            if(sum == 0){
                min = liquids[L];
                max = liquids[R];
                break;
            }
            if(ans >= Math.abs(sum)){
                ans = Math.abs(sum);
                min = liquids[L];
                max = liquids[R];
            }
            if(sum > 0){
                R--;
            }else{
                L++;
            }
        }
        sb.append(min).append(" ").append(max);
        System.out.println(sb.toString());
    }
}
