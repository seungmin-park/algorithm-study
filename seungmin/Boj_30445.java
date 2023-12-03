import java.io.*;
import java.util.*;

public class Boj_30445 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static List<Character> happy = List.of('H', 'A', 'P', 'Y');
    static List<Character> sad = List.of('S', 'A', 'D');
    static List<String> words = new ArrayList<>();
    static String target;
    static float ans;
    static int happyPoint, sadPoint;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        while (st.hasMoreTokens()) {
            words.add(st.nextToken());
        }

        for (String word : words) {
            for (int i = 0; i < word.length(); i++) {
                if (happy.contains(word.charAt(i))) {
                    happyPoint++;
                }
                if (sad.contains(word.charAt(i))) {
                    sadPoint++;
                }
            }
        }

        if (happyPoint == 0 && sadPoint == 0) {
            ans = 0.5f;
        } else {
            ans = (float) happyPoint / (happyPoint + sadPoint);
        }
        System.out.printf(String.format("%.2f", ans * 100));
    }
}
