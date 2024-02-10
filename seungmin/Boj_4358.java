import java.io.*;
import java.util.*;

public class Boj_4358 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static Map<String, Integer> tree = new TreeMap<>();
    static String input;
    static int cnt;

    public static void main(String[] args) throws IOException {
        while ((input = br.readLine()) != null) {
            cnt++;
            tree.put(input, tree.getOrDefault(input, 0) + 1);
        }

        for (String name : tree.keySet()) {
            System.out.printf("%s %.4f\n", name, (tree.get(name) / (double) cnt) * 100);
        }

        System.out.println(sb);
    }
}
