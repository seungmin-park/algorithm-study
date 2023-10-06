import java.io.*;
import java.util.*;

public class Boj_25945 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int[] containers;
    static int n, m, avg, overCnt, lessCnt;

    public static void main(String[] args) throws IOException {
        n = Integer.parseInt(br.readLine());
        containers = new int[n];
        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++) {
            int target = Integer.parseInt(st.nextToken());
            m += target;
            containers[i] = target;
        }

        avg = m / n;

        for (int container : containers) {
            if (container < avg) {
                lessCnt += avg - container;
            } else if (container > avg + 1) {
                overCnt += container - avg - 1;
            }
        }
        System.out.println(Math.max(lessCnt, overCnt));
    }
}
