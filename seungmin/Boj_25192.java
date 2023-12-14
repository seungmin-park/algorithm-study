import java.io.*;
import java.util.*;

public class Boj_25192 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static Set<String> set = new HashSet<>();
    static int N, ans;

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());

        for (int i = 1; i <= N; i++) {
            String now = br.readLine();
            if (now.equals("ENTER")) {
                ans += set.size();
                set = new HashSet<>();
                continue;
            }
            set.add(now);
        }

        ans += set.size();

        System.out.println(ans);
    }
}
