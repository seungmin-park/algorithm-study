import java.io.*;
import java.util.*;

public class Boj_16928 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static Map<Integer, Integer> bonus = new HashMap<>();
    static int[] distance = new int[101];
    static int N, M;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        for (int i = 1; i <= N + M; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());

            bonus.put(from, to);
        }

        for (int i = 1; i <= 100; i++) {
            distance[i] = Integer.MAX_VALUE;
        }
        bfs(1, 0);

        System.out.println(distance[100]);
    }

    static void bfs(int start, int dist) {
        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        distance[start] = 0;

        while (!q.isEmpty()) {
            int now = q.poll();
            for (int i = 1; i <= 6; i++) {
                int next = bonus.getOrDefault(now + i, now + i);
                if (next >= 100) {
                    distance[100] = Math.min(distance[now] + 1, distance[100]);
                    continue;
                }
                if (distance[next] > distance[now] + 1) {
                    distance[next] = distance[now] + 1;
                    q.add(next);
                }
            }
        }
    }
}
