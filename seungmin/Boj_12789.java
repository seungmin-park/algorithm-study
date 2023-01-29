import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

public class Boj_12789 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int N;
    static Queue<Integer> wait = new LinkedList<>();
    static Stack<Integer> empty = new Stack<>();

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            wait.add(Integer.parseInt(st.nextToken()));
        }

        int current = 1;
        while (!wait.isEmpty()) {
            int now = wait.peek();
            if (now == current) {
                wait.poll();
                current++;
                continue;
            }
            if (!empty.isEmpty()) {
                int div = empty.peek();
                if (div == current) {
                    empty.pop();
                    current++;
                    continue;
                }
            }
            empty.add(wait.poll());
        }

        while (!empty.isEmpty()) {
            int now = empty.pop();
            if (now == current) {
                current++;
                continue;
            }
            System.out.println("Sad");
            return;
        }

        System.out.println("Nice");
    }
}
