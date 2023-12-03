import java.io.*;
import java.util.*;

public class Boj_17219 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static Map<String, String> passwords = new HashMap<>();
    static int N, M;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            String web = st.nextToken();
            String password = st.nextToken();
            passwords.put(web, password);
        }

        for (int i = 1; i <= M; i++) {
            String web = br.readLine();
            sb.append(passwords.get(web)).append("\n");
        }

        System.out.println(sb);
    }
}
