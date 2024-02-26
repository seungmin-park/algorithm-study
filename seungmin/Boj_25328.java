import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class Boj_25328 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static Map<String, Integer> frequency = new TreeMap<>();
    static String X, Y, Z;
    static int k;

    public static void main(String[] args) throws IOException {
        X = br.readLine();
        Y = br.readLine();
        Z = br.readLine();
        k = Integer.parseInt(br.readLine());

        func(0, 0, X, new ArrayList<>());
        func(0, 0, Y, new ArrayList<>());
        func(0, 0, Z, new ArrayList<>());

        List<String> collect = frequency.keySet()
                .stream().filter(word -> frequency.get(word) > 1)
                .collect(Collectors.toList());

        if (collect.isEmpty()) {
            System.out.println(-1);
        } else {
            for (String s : collect) {
                sb.append(s).append("\n");
            }

            System.out.println(sb);
        }
    }

    static void func(int K, int idx, String target, List<Character> word) {
        if (k == K) {
            //logic
            StringBuilder builder = new StringBuilder();
            for (Character c : word) {
                builder.append(c);
            }

            frequency.put(builder.toString(), frequency.getOrDefault(builder.toString(), 0) + 1);
            return;
        }
        for (int i = idx; i < target.length(); i++) {
            word.add(target.charAt(i));
            func(K + 1, i + 1, target, word);
            word.remove(word.size() - 1);
        }
    }
}
