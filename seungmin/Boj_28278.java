import java.io.*;
import java.util.*;

public class Boj_28278 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static Stack<Integer> stack = new Stack<>();
    static int N;

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            int option = Integer.parseInt(st.nextToken());
            if (option == 1) {
                int value = Integer.parseInt(st.nextToken());
                stack.push(value);
                continue;
            }
            if (option == 2) {
                if (stack.isEmpty()) {
                    sb.append(-1).append("\n");
                    continue;
                }
                sb.append(stack.pop()).append("\n");
                continue;
            }
            if (option == 3) {
                sb.append(stack.size()).append("\n");
                continue;
            }
            if (option == 4) {
                if (stack.isEmpty()) {
                    sb.append(1).append("\n");
                    continue;
                }
                sb.append(0).append("\n");
                continue;
            }
            if (option == 5) {
                if (stack.isEmpty()) {
                    sb.append(-1).append("\n");
                    continue;
                }
                sb.append(stack.peek()).append("\n");
                continue;
            }
        }

        System.out.println(sb);
    }
}
