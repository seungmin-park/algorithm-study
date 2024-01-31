import java.io.*;
import java.util.*;

public class Boj_11656 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static List<String> posts = new ArrayList<>();
    static String target;

    public static void main(String[] args) throws IOException {
        target = br.readLine();
        int length = target.length();

        for (int i = 0; i < length; i++) {
            posts.add(target.substring(i, length));
        }

        posts.stream()
                .sorted()
                .forEach(post -> sb.append(post).append("\n"));

        System.out.println(sb);
    }
}
