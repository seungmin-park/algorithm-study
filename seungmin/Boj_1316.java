import java.io.*;
import java.util.*;

public class Boj_1316 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static boolean[] alphabets = new boolean[26];
    static int N, ans;

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        for (int i = 1; i <= N; i++) {
            Arrays.fill(alphabets, false);
            boolean isGroupWord = true;
            String word = br.readLine();
            char beforeAlphabet = word.charAt(0);
            alphabets[beforeAlphabet - 97] = true;
            for (int j = 1; j < word.length(); j++) {
                if (word.charAt(j) == beforeAlphabet)
                    continue;
                if (alphabets[word.charAt(j) - 97]) {
                    isGroupWord = false;
                    break;
                } else {
                    alphabets[word.charAt(j) - 97] = true;
                    beforeAlphabet = word.charAt(j);
                }
            }
            if (isGroupWord) {
                ans++;
            }
            isGroupWord = true;
        }

        System.out.println(ans);
    }
}