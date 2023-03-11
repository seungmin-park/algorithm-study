import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.TreeMap;

public class Boj_1302 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static Map<String, Integer> books = new TreeMap<>();
    static String ans;
    static int N;

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        for (int i = 1; i <= N; i++) {
            String bookName = br.readLine();
            books.put(bookName, books.getOrDefault(bookName, 0) + 1);
        }

        int maxCnt = books.values()
                .stream()
                .mapToInt(Integer::intValue)
                .max()
                .stream().findFirst().getAsInt();

        ans = books.keySet()
        .stream()
        .filter(k -> books.get(k) == maxCnt)
        .findFirst().get();

        System.out.println(ans);
    }
}
