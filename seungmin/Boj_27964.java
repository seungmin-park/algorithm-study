import java.io.*;
import java.util.*;

public class Boj_27964 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static Set<String> chesse = new HashSet<>();
    static int N;

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            String topping = st.nextToken();
            if (topping.endsWith("Cheese")) {
                chesse.add(topping);
            }
        }

        if (chesse.size() >= 4) {
            System.out.println("yummy");
        } else {
            System.out.println("sad");
        }
    }
}
