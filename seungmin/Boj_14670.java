import java.io.*;
import java.util.*;

public class Boj_14670 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static Map<Integer, Integer> medical = new HashMap<>();
    static int N, R;

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            int effective = Integer.parseInt(st.nextToken());
            int name = Integer.parseInt(st.nextToken());
            medical.put(effective, name);
        }

        R = Integer.parseInt(br.readLine());
        for (int i = 1; i <= R; i++) {
            st = new StringTokenizer(br.readLine());
            List<Integer> diseases = new ArrayList<>();
            int count = Integer.parseInt(st.nextToken());
            for (int c = 1; c <= count; c++) {
                int disease = Integer.parseInt(st.nextToken());
                diseases.add(disease);
            }

            boolean isDied = false;
            for (int c = 0; c < count; c++) {
                int disease = diseases.get(c);
                if (!medical.containsKey(disease)) {
                    isDied = true;
                    break;
                }
            }
            if (isDied) {
                sb.append("YOU DIED");
            } else {
                for (int c = 0; c < count; c++) {
                    int disease = diseases.get(c);
                    sb.append(medical.get(disease)).append(" ");
                }
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }
}
