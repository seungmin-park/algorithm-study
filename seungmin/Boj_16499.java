import java.io.*;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Boj_16499 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static Set<String> words = new HashSet<>();
    static int N;

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        for (int i = 1; i <= N; i++) {
            char[] word = br.readLine().toCharArray();
            Arrays.sort(word);
            StringBuilder sb = new StringBuilder();
            for (char c : word) {
                sb.append(c);
            }
            words.add(sb.toString());
        }

        System.out.println(words.size());
    }
}
