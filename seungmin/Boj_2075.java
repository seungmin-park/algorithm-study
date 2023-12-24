import java.io.*;
import java.util.*;

public class Boj_2075 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static List<Integer> list = new ArrayList<>();
    static int N;

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                list.add(Integer.parseInt(st.nextToken()));
            }
        }

        list.sort(Collections.reverseOrder());

        System.out.println(list.get(N - 1));
    }
}
