import java.io.*;
import java.util.*;

public class Boj_27497 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static Deque<String> dq = new ArrayDeque<>();
    static Stack<String> command = new Stack<>();
    static int N;

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            String option = st.nextToken();
            if (option.equals("1")) {
                String target = st.nextToken();
                dq.addLast(target);
                command.add("1");
                continue;
            }
            if (option.equals("2")) {
                String target = st.nextToken();
                dq.addFirst(target);
                command.add("2");
                continue;
            }
            if (option.equals("3")) {
                if (command.isEmpty()) {
                    continue;
                }
                String beforeCommand = command.pop();
                if (beforeCommand.equals("1")) {
                    dq.pollLast();
                    continue;
                }
                if (beforeCommand.equals("2")) {
                    dq.pollFirst();
                    continue;
                }
            }
        }

        if (dq.isEmpty()) {
            sb.append(0);
        } else {
            for (String e : dq) {
                sb.append(e);
            }
        }

        System.out.println(sb);
    }
}
