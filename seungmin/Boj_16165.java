import java.io.*;
import java.util.*;

public class Boj_16165 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static Map<String, List<String>> group = new HashMap<>();
    static int N, M;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        for (int i = 1; i <= N; i++) {
            String groupName = br.readLine();
            int cnt = Integer.parseInt(br.readLine());
            group.put(groupName, new ArrayList<>());
            for (int j = 1; j <= cnt; j++) {
                group.get(groupName).add(br.readLine());
            }
        }

        for (int i = 1; i <= M; i++) {
            String problem = br.readLine();
            int option = Integer.parseInt(br.readLine());
            if (option == 0) {
                group.get(problem).stream()
                        .sorted()
                        .forEach(member -> sb.append(member).append("\n"));
                continue;
            }

            sb.append(group.keySet().stream()
                    .filter(groupName -> group.get(groupName).contains(problem))
                    .findFirst()
                    .get()).append("\n");
        }

        System.out.println(sb);
    }
}
