import java.io.*;
import java.util.*;

/**
 * 오답 테스트케이스
 * input:
 * 0 0
 * output:
 * 0
 * 0
 * input:
 * 0 1
 * output:
 * 1
 * 0 1
 */
public class Boj_13913 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static List<Integer> paths = new ArrayList<>();
    static int[] distance = new int[100_001], dir = { 1, -1, 2 };
    static int start, end;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        start = Integer.parseInt(st.nextToken());
        end = Integer.parseInt(st.nextToken());

        Arrays.fill(distance, -2);

        bfs();
        int now = end;
        while (now != -1) {
            paths.add(now);
            now = distance[now];
        }

        sb.append(paths.size() - 1).append("\n");
        for (int i = paths.size() - 1; i > -1; i--) {
            sb.append(paths.get(i)).append(" ");
        }

        System.out.println(sb);
    }

    static void bfs() {
        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        distance[start] = -1;

        while (!q.isEmpty()) {
            int now = q.poll();
            for (int i = 0; i < 3; i++) {
                int next = 0;
                if (i == 2) {
                    next = now * dir[i];
                } else {
                    next = now + dir[i];
                }
                if (next < 0 || next > 100_000) {
                    continue;
                }
                if (distance[next] != -2) {
                    continue;
                }
                distance[next] = now;
                q.add(next);
            }
        }
    }
}
