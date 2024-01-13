import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class Boj_25325 {
    static class Stundet {
        String name;
        int score;

        Stundet(String name, int score) {
            this.name = name;
            this.score = score;
        }
    }

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static Map<String, Integer> students = new HashMap<>();
    static int N;

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        while (st.hasMoreTokens()) {
            students.put(st.nextToken(), 0);
        }

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            while (st.hasMoreTokens()) {
                String name = st.nextToken();
                students.put(name, students.get(name) + 1);
            }
        }

        students.keySet()
            .stream()
            .map(name -> new Stundet(name, students.get(name)))
            .sorted((s1, s2) -> {
                if (s1.score == s2.score) {
                    return s1.name.compareTo(s2.name);
                }
                return s2.score - s1.score;
            })
            .collect(Collectors.toList())
            .forEach(s -> sb.append(s.name).append(" ").append(s.score).append("\n"));

        System.out.println(sb);
    }
}
