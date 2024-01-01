import java.io.*;
import java.util.*;

public class Boj_25757 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static Map<String, Integer> gameType = new HashMap<>();
    static Set<String> member = new HashSet<>();
    static int N;

    public static void main(String[] args) throws IOException {
        gameType.put("Y", 1);
        gameType.put("F", 2);
        gameType.put("O", 3);

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        String type = st.nextToken();

        for (int i = 1; i <= N; i++) {
            member.add(br.readLine());
        }

        System.out.println(member.size() / gameType.get(type));
    }
}
