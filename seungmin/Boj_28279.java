import java.io.*;
import java.util.*;

public class Boj_28279 {
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
            if (command.equals("1") || command.equals("2")) {
                value = Integer.parseInt(st.nextToken());
            }
            if (command.equals("1")) {
                dq.offerFirst(value);
            } else if (command.equals("2")) {
                dq.offerLast(value);
            } else if (command.equals("3")) {
                if (dq.size() == 0) {
                    sb.append(-1);
                } else {
                    sb.append(dq.removeFirst());
                }
                sb.append("\n");
            } else if (command.equals("4")) {
                if (dq.size() == 0) {
                    sb.append(-1);
                } else {
                    sb.append(dq.removeLast());
                }
                sb.append("\n");
            } else if (command.equals("5")) {
                sb.append(dq.size()).append("\n");
            } else if (command.equals("6")) {
                if (dq.size() == 0) {
                    sb.append(1);
                } else {
                    sb.append(0);
                }
                sb.append("\n");
            } else if (command.equals("7")) {
                if (dq.size() == 0) {
                    sb.append(-1);
                } else {
                    sb.append(dq.peekFirst());
                }
                sb.append("\n");
            } else if (command.equals("8")) {
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
