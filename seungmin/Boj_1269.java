import java.io.*;
import java.util.*;

public class Boj_1269 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static Set<Integer> A = new HashSet<>();
    static Set<Integer> B = new HashSet<>();
    static int N, M;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            A.add(Integer.parseInt(st.nextToken()));
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= M; i++) {
            B.add(Integer.parseInt(st.nextToken()));
        }

        Set<Integer> C = new HashSet<>();
        for (int a : A) {
            if (B.contains(a)) {
                C.add(a);
            }
        }

        System.out.println(A.size() - C.size() + B.size() - C.size());
    }
}
