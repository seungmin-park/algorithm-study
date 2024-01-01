import java.io.*;
import java.util.*;

public class Boj_17952 {
    static class Subject {
        int score, remain;

        public Subject(int score, int remain) {
            this.score = score;
            this.remain = remain;
        }
    }

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static Stack<Subject> reminder = new Stack<>();
    static Subject now;
    static int N, ans;

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            String option = st.nextToken();
            if (option.equals("0")) {
                if (now != null) {
                    now.remain--;
                    if (now.remain <= 0) {
                        ans += now.score;
                        now = null;
                        if (!reminder.isEmpty()) {
                            now = reminder.pop();
                            continue;
                        }
                    }
                    continue;
                }
                if (!reminder.isEmpty()) {
                    now = reminder.pop();
                    now.remain--;
                    if (now.remain <= 0) {
                        ans += now.score;
                        now = null;
                        if (!reminder.isEmpty()) {
                            now = reminder.pop();
                        }
                    }
                }
            } else if (option.equals("1")) {
                int score = Integer.parseInt(st.nextToken());
                int remain = Integer.parseInt(st.nextToken());
                if (now != null) {
                    reminder.push(now);
                }
                now = new Subject(score, remain);
                now.remain--;
                if (now.remain <= 0) {
                    ans += now.score;
                    now = null;
                    if (!reminder.isEmpty()) {
                        now = reminder.pop();
                    }
                }
            }
        }

        System.out.println(ans);
    }
}
