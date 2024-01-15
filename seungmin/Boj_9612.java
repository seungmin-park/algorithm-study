import java.io.*;
import java.util.*;

public class Boj_9612 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static Map<String, Integer> dic = new HashMap<>();
    static int N;

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        for (int i = 1; i <= N; i++) {
            String name = br.readLine();
            dic.put(name, dic.getOrDefault(name, 0) + 1);
        }

        int max = dic.keySet()
                .stream()
                .mapToInt(key -> dic.get(key))
                .max()
                .getAsInt();

        String ans = dic.keySet()
                .stream()
                .filter(key -> dic.get(key) == max)
                .sorted((key1, key2) -> dic.get(key2) - dic.get(key1))
                .findFirst()
                .get();

        sb.append(ans).append(" ").append(max);
        System.out.println(sb);
    }
}
