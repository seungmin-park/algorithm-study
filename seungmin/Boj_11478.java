import java.io.*;
import java.util.*;

public class Boj_11478 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static Set<String> cand = new HashSet<>();
    static String s;

    public static void main(String[] args) throws IOException {
        s = br.readLine();

        for (int i = 0; i < s.length(); i++) {
            for (int j = i + 1; j <= s.length(); j++) {
                cand.add(s.substring(i, j));
            }
        }

        System.out.println(cand.size());
    }
}
