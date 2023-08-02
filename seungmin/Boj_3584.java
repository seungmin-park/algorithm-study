import java.io.*;
import java.util.*;

public class Boj_3584 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static int[] parents;
    static int T, N;

    public static void main(String[] args) throws IOException {
        T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            N = Integer.parseInt(br.readLine());
            parents = new int[N + 1];
            for (int i = 1; i <= N; i++) {
                parents[i] = -1;
            }

            for (int i = 1; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                int parent = Integer.parseInt(st.nextToken());
                int child = Integer.parseInt(st.nextToken());

                parents[child] = parent;
            }

            int ans = -1;
            st = new StringTokenizer(br.readLine());
            int targetA = Integer.parseInt(st.nextToken());
            int targetB = Integer.parseInt(st.nextToken());
            List<Integer> taregetAParents = new ArrayList<>();
            List<Integer> taregetBParents = new ArrayList<>();
            searchParents(targetA, taregetAParents);
            searchParents(targetB, taregetBParents);
            for (int parent : taregetAParents) {
                if (ans != -1) {
                    break;
                }
                ans = taregetBParents.stream()
                        .filter(p -> p == parent)
                        .findFirst().orElse(-1);
            }

            sb.append(ans).append("\n");
        }

        System.out.println(sb);
    }

    static void searchParents(int target, List<Integer> parentsList) {
        parentsList.add(target);
        while (parents[target] != -1) {
            parentsList.add(parents[target]);
            target = parents[target];
        }
    }
}
