import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_14659 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int N, result, loc, next;

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());

        loc = Integer.parseInt(st.nextToken());
        int killCnt = 0;
        while (--N > 0) {
            next = Integer.parseInt(st.nextToken());
            if (loc > next) {
                result = Math.max(result, ++killCnt);
            } else {
                loc = next;
                killCnt = 0;
            }
        }

        System.out.println(result);
    }
}
