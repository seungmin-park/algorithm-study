import java.io.*;
import java.util.*;

public class Boj_10546 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static Map<String, Integer> list = new HashMap<>();
    static int N;

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        for (int i = 1; i <= N; i++) {
            String name = br.readLine();
            list.put(name, list.getOrDefault(name, 0) + 1);
        }

        for (int i = 1; i < N; i++) {
            String name = br.readLine();
            list.put(name, list.getOrDefault(name, 0) - 1);
        }

        for (String name : list.keySet()) {
            if (list.get(name) > 0) {
                System.out.println(name);
                return;
            }
        }
    }
}
