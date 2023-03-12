import java.io.*;
import java.util.*;

public class Boj_25305 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int[] scores;
    static int N, K;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        scores = new int[N + 1];

        st = new StringTokenizer(br.readLine());
        for(int i = 1; i <=N; i++){
            scores[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(scores, 1, N + 1);

        System.out.println(scores[N - K + 1]);
    }
}
