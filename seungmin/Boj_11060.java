import java.io.*;
import java.util.*;

public class Boj_11060 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int[] miro, distance;
    static int N;

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        miro = new int[N + 1];
        distance = new int[N + 1];

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            miro[i] = Integer.parseInt(st.nextToken());
            distance[i] = -1;
        }

        bfs();

        System.out.println(distance[N]);
    }

    static void bfs() {
        Queue<Integer> q = new LinkedList<>();
        q.add(1);
        distance[1] = 0;

        while (!q.isEmpty()) {
            int nowIdx = q.poll();
            int canMoveCnt = miro[nowIdx];
            for (int i = 1; i <= canMoveCnt; i++) {
                if (nowIdx + i > N || distance[nowIdx + i] != -1) {
                    continue;
                }
                distance[nowIdx + i] = distance[nowIdx] + 1;
                q.add(nowIdx + i);
            }
        }
    }
}
