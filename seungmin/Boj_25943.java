import java.io.*;
import java.util.*;

public class Boj_25943 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int[] weights = { 100, 50, 20, 10, 5, 2, 1 };
    static int N, left, right, goal, ans;

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        left = Integer.parseInt(st.nextToken());
        right = Integer.parseInt(st.nextToken());

        while (st.hasMoreTokens()) {
            int target = Integer.parseInt(st.nextToken());
            if (left <= right) {
                left += target;
                continue;
            }
            right += target;
        }
        goal = Math.abs(left - right);

        if (goal == 0) {
            System.out.println(0);
            return;
        }


        for (int w : weights) {
            if(goal / w != 0){
                ans += goal / w;
                goal %= w;
            }
        }
        System.out.println(ans);
    }
}
