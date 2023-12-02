import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Boj_18258 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static Deque<Integer> q = new LinkedList<>();
    static int N;

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            String command = st.nextToken();
            if (command.equals("push")) {
                int value = Integer.parseInt(st.nextToken());
                push(value);
                continue;
            }
            if (command.equals("pop")) {
                pop();
                continue;
            }
            if (command.equals("size")) {
                size();
                continue;
            }
            if (command.equals("empty")) {
                empty();
                continue;
            }
            if (command.equals("top")) {
                top();
                continue;
            }
            if (command.equals("front")) {
                front();
                continue;
            }
            if (command.equals("back")) {
                back();
            }
        }
        System.out.print(sb.toString());
    }

    private static void back() {
        if (q.isEmpty()) {
            sb.append(-1).append("\n");
        } else {
            sb.append(q.peekLast()).append("\n");
        }
    }

    private static void front() {
        if (q.isEmpty()) {
            sb.append(-1).append("\n");
        } else {
            sb.append(q.peekFirst()).append("\n");
        }
    }

    private static void top() {
        if (q.isEmpty()) {
            sb.append(-1).append("\n");
        } else {
            sb.append(q.poll()).append("\n");
        }
    }

    private static void empty() {
        if (q.isEmpty()) {
            sb.append(1).append("\n");
        } else {
            sb.append(0).append("\n");
        }
    }

    private static void size() {
        sb.append(q.size()).append("\n");
    }

    private static void pop() {
        if (q.isEmpty()) {
            sb.append(-1).append("\n");
        } else {
            sb.append(q.poll()).append("\n");
        }
    }

    private static void push(int value) {
        q.add(value);
    }
}