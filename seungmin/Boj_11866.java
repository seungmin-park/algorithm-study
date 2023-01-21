import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Boj_11866 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static ArrayList<Integer> list = new ArrayList<>();
    static ArrayList<Integer> result = new ArrayList<>();
    static int K, N;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        for (int i = 1; i <= N; i++) {
            list.add(i);
        }

        int loc = 0;
        while (list.size() != 0) {
            loc = (loc + (K - 1)) % list.size();
            result.add(list.remove(loc));
        }

        sb.append("<").append(result.get(0));
        for (int i = 1; i < result.size(); i++) {
            sb.append(", ").append(result.get(i));
        }
        sb.append(">");

        System.out.println(sb);
    }
}
