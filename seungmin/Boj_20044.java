import java.io.*;
import java.util.*;

public class Boj_20044 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int[] students;
    static int n, ans = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        n = Integer.parseInt(br.readLine());
        students = new int[2 * n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 2 * n; i++) {
            students[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(students);

        for (int i = 0; i < n; i++) {
            ans = Math.min(ans, students[i] + students[2 * n - i - 1]);
        }

        System.out.println(ans);
    }
}
