import java.io.*;
import java.util.*;

public class Boj_17204 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static List<Integer>[] game;
    static int[] distance;
    static int N, W;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        W = Integer.parseInt(st.nextToken());

        game = new ArrayList[N + 1];
        distance = new int[N + 1];
        for (int i = 0; i < N; i++) {
            game[i] = new ArrayList<>();
            distance[i] = -1;
        }

        for (int i = 0; i < N; i++) {
            int to = Integer.parseInt(br.readLine());
            game[i].add(to);
        }
        bfs(0);

        System.out.println(distance[W]);
    }

    static void bfs(int start) {
        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        distance[start] = 0;

        while (!q.isEmpty()) {
            int now = q.poll();
            for (int next : game[now]) {
                if (distance[next] != -1) {
                    continue;
                }
                q.add(next);
                distance[next] = distance[now] + 1;
            }
        }
    }
}
