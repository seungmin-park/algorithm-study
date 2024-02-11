import java.io.*;
import java.util.*;

public class Boj_1244 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static int[] switchStatus;
    static int N, T;
    static final int MALE = 1;
    static final int FEMALE = 2;

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        switchStatus = new int[N + 1];

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            switchStatus[i] = Integer.parseInt(st.nextToken());
        }

        T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            st = new StringTokenizer(br.readLine());
            int gender = Integer.parseInt(st.nextToken());
            int num = Integer.parseInt(st.nextToken());
            if (gender == MALE) {
                for (int i = 1; i <= N; i++) {
                    if (i % num == 0) {
                        changeStatus(i);
                    }
                }
            } else if (gender == FEMALE) {
                int left = num;
                int right = num;
                while (0 < left - 1 && right + 1 <= N) {
                    left--;
                    right++;
                    if (switchStatus[left] != switchStatus[right]) {
                        left++;
                        right--;
                        break;
                    }
                }
                for (int i = left; i <= right; i++) {
                    changeStatus(i);
                }
            }
        }

        for (int i = 1; i <= N; i++) {
            sb.append(switchStatus[i]).append(" ");
            if (i % 20 == 0) {
                sb.append("\n");
            }
        }

        System.out.println(sb);
    }

    static void changeStatus(int number) {
        switchStatus[number] = switchStatus[number] == 1 ? 0 : 1;
    }
}
