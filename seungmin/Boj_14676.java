import java.io.*;
import java.util.*;

public class Boj_14676 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static List<Integer>[] objects;
    static int[] objCnt;
    static int[] indeg;
    static int N, M, K;
    static final int CREATE = 1;
    static final int DESTORY = 2;
    static final String FAIR = "King-God-Emperor";
    static final String FAKE = "Lier!";

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        objects = new ArrayList[N + 1];
        indeg = new int[N + 1];
        objCnt = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            objects[i] = new ArrayList<>();
        }

        for (int i = 1; i <= M; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            objects[from].add(to);
            indeg[to]++;
        }

        for (int k = 1; k <= K; k++) {
            st = new StringTokenizer(br.readLine());
            int action = Integer.parseInt(st.nextToken());
            int target = Integer.parseInt(st.nextToken());
            if (action == CREATE) {
                if (indeg[target] != 0) {
                    System.out.println(FAKE);
                    return;
                }
                if (objCnt[target]++ == 0) {
                    for (int next : objects[target]) {
                        indeg[next]--;
                    }
                }
            }
            if (action == DESTORY) {
                if (objCnt[target] == 0) {
                    System.out.println(FAKE);
                    return;
                }

                if (--objCnt[target] == 0) {
                    for (int next : objects[target]) {
                        indeg[next]++;
                    }
                }
            }
        }

        System.out.println(FAIR);
    }
}
