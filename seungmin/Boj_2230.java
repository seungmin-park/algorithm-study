import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 정답의 최대치: 20억
 * 각 원소의 범위: 0 ~ 10억
 * 두 수를 뽑아 그 차이를 확인해야 하므로 연산 중에 나올 수 있는 값의 최대치 10억 -> int 범위
 * 원소의 개수 최대 10만
 * 1. 각 원소에 대해 차이를 구하는 완전 탐색 O(N^2): 100억
 * 2. 원소 정렬 O(NlogN) -> 50만
 * 2-1. 투포인터 탐색: O(2N) -> O(N)
 */
public class Boj_2230 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int[] A;
    static int N, M;
    static int ans = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        A = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            A[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(A);

        int L = 1;
        int R = 1;
        while (R <= N) {
            int minus = A[R] - A[L];
            if (minus < M) {
                R++;
            } else if (minus > M) {
                L++;
                ans = Math.min(ans, minus);
            } else {
                System.out.println(M);
                return;
            }
        }

        System.out.println(ans);
    }
}
