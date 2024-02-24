import java.io.*;
import java.util.*;

public class Boj_15233 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static Set<String> AGroup = new HashSet<>();
    static Set<String> BGroup = new HashSet<>();
    static Map<String, Integer> goal = new HashMap<>();
    static int A, B, G;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        A = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());
        G = Integer.parseInt(st.nextToken());
        goal.put("A", 0);
        goal.put("B", 0);

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= A; i++) {
            AGroup.add(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= B; i++) {
            BGroup.add(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= G; i++) {
            String name = st.nextToken();
            if (AGroup.contains(name)) {
                goal.put("A", goal.get("A") + 1);
                continue;
            }
            goal.put("B", goal.get("B") + 1);
        }

        if (goal.get("A") == goal.get("B")) {
            System.out.println("TIE");
            return;
        }
        if (goal.get("A") > goal.get("B")) {
            System.out.println("A");
            return;
        }
        System.out.println("B");
    }
}
