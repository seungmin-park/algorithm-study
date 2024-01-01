import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class Boj_9536 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static List<String> cand;
    static int T;

    public static void main(String[] args) throws IOException {
        T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            cand = new ArrayList<>();
            st = new StringTokenizer(br.readLine());

            while (st.hasMoreTokens()) {
                cand.add(st.nextToken());
            }

            String input;
            while (!(input = br.readLine()).equals("what does the fox say?")) {
                String sound = input.split(" ")[2];
                cand = cand.stream()
                        .filter(c -> !c.equals(sound))
                        .collect(Collectors.toList());
            }

            for (String c : cand) {
                sb.append(c).append(" ");
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }
}
