import java.io.*;
import java.util.*;

public class Boj_6443 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static Set<String> words = new TreeSet<>();
    static String word;
    static int[] cnt;
    static int N;

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        for (int i = 1; i <= N; i++) {
            words = new TreeSet<>();
            word = br.readLine();
            cnt = new int[26];
            for (int j = 0; j < word.length(); j++) {
                cnt[word.charAt(j) - 'a']++;
            }
            func(0, word.length(), new StringBuilder());

            for (String word : words) {
                sb.append(word).append("\n");
            }
        }

        System.out.println(sb);
    }

    static void func(int k, int length, StringBuilder current) {
        if (k == length) {
            words.add(current.toString());
            return;
        }

        for (int i = 0; i < 26; i++) {
            if (cnt[i] < 1) {
                continue;
            }
            cnt[i]--;
            current.append((char) (i + 'a'));
            func(k + 1, length, current);
            current.deleteCharAt(current.length() - 1);
            cnt[i]++;
        }
    }
}