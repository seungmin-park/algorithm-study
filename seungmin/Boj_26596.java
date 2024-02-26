import java.io.*;
import java.util.*;

public class Boj_26596 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static Map<String, Integer> recipe = new HashMap<>();
    static int N;

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            String name = st.nextToken();
            int volume = Integer.parseInt(st.nextToken());
            recipe.put(name, recipe.getOrDefault(name, 0) + volume);
        }

        List<Integer> volumes = new ArrayList<>(recipe.values());

        for (int i = 0; i < volumes.size() - 1; i++) {
            for (int j = i + 1; j < volumes.size(); j++) {
                if ((int) (volumes.get(i) * 1.618) == volumes.get(j) || (int) (volumes.get(j) * 1.618) == volumes.get(i)) {
                    System.out.println("Delicious!");
                    return;
                }
            }
        }
        System.out.println("Not Delicious...");
    }
}
