import java.io.*;
import java.util.*;

public class Boj_10866 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static Deque<Integer> dq = new ArrayDeque<>();
    static int N;

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            String command = st.nextToken();
            int value = -1;
            if (command.contains("push")) {
                value = Integer.parseInt(st.nextToken());
            }
            if (command.equals("push_front")) {
                dq.offerFirst(value);
            } else if (command.equals("push_back")) {
                dq.offerLast(value);
            } else if (command.equals("pop_front")) {
                if (dq.size() == 0) {
                    sb.append(-1);
                } else {
                    sb.append(dq.removeFirst());
                }
                sb.append("\n");
            } else if (command.equals("pop_back")) {
                if (dq.size() == 0) {
                    sb.append(-1);
                } else {
                    sb.append(dq.removeLast());
                }
                sb.append("\n");
            } else if (command.equals("size")) {
                sb.append(dq.size()).append("\n");
            } else if (command.equals("empty")) {
                if (dq.size() == 0) {
                    sb.append(1);
                } else {
                    sb.append(0);
                }
                sb.append("\n");
            } else if (command.equals("front")) {
                if (dq.size() == 0) {
                    sb.append(-1);
                } else {
                    sb.append(dq.peekFirst());
                }
                sb.append("\n");
            } else if (command.equals("back")) {
                if (dq.size() == 0) {
                    sb.append(-1);
                } else {
                    sb.append(dq.peekLast());
                }
                sb.append("\n");
            }
        }

        System.out.println(sb);
    }
}
