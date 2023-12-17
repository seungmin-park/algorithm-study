import java.io.*;
import java.util.*;

public class Boj_20920 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static Map<String, Integer> words = new HashMap<>();
    static StringTokenizer st;
    static int N, M;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        for (int i = 1; i <= N; i++) {
            String word = br.readLine();
            if (word.length() < M) {
                continue;
            }
            words.put(word, words.getOrDefault(word, 0) + 1);
        }

        words.entrySet()
                .stream()
                .sorted((k1, k2) -> {
                    if (k1.getValue() != k2.getValue()) {
                        return k2.getValue() - k1.getValue();
                    }
                    if (k1.getKey().length() != k2.getKey().length()) {
                        return k2.getKey().length() - k1.getKey().length();
                    }
                    return k1.getKey().compareTo(k2.getKey());
                })
                .forEach(e -> sb.append(e.getKey()).append("\n"));

        System.out.println(sb);
    }
}
