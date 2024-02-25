import java.io.*;
import java.util.*;

public class Boj_11645 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static Set<String> people;
    static int T, N;

    public static void main(String[] args) throws IOException {
        T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            N = Integer.parseInt(br.readLine());
            people = new HashSet<>();
            for (int i = 1; i <= N; i++) {
                people.add(br.readLine());
            }
            sb.append(people.size()).append("\n");
        }

        System.out.println(sb);
    }
}
