import java.io.*;
import java.util.*;

public class Boj_17479 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static Map<String, Integer> commonMenu = new HashMap<>();
    static Map<String, Integer> specialMenu = new HashMap<>();
    static Map<String, Integer> orders = new HashMap<>();
    static Set<String> serviceMenus = new HashSet<>();
    static String orderedServiceMenu = null;
    static long amount;
    static int A, B, C, N;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        A = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        for (int i = 1; i <= A; i++) {
            st = new StringTokenizer(br.readLine());
            commonMenu.put(st.nextToken(), Integer.parseInt(st.nextToken()));
        }

        for (int i = 1; i <= B; i++) {
            st = new StringTokenizer(br.readLine());
            specialMenu.put(st.nextToken(), Integer.parseInt(st.nextToken()));
        }

        for (int i = 1; i <= C; i++) {
            serviceMenus.add(br.readLine());
        }

        N = Integer.parseInt(br.readLine());
        for (int i = 1; i <= N; i++) {
            String menu = br.readLine();
            if (serviceMenus.contains(menu)) {
                if (orderedServiceMenu != null) {
                    System.out.println("No");
                    return;
                }
                orderedServiceMenu = menu;
                continue;
            }
            orders.put(menu, orders.getOrDefault(menu, 0) + 1);
        }

        for (String menu : orders.keySet()) {
            if (commonMenu.keySet().contains(menu)) {
                amount += orders.get(menu) * commonMenu.get(menu);
            }
        }

        for (String menu : orders.keySet()) {
            if (specialMenu.keySet().contains(menu)) {
                if (amount >= 20_000) {
                    amount += orders.get(menu) * specialMenu.get(menu);
                } else {
                    System.out.println("No");
                    return;
                }
            }
        }

        if (orderedServiceMenu != null && amount < 50_000) {
            System.out.println("No");
            return;
        }

        System.out.println("Okay");
    }
}
