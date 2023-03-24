import java.util.*;
import java.io.*;

public class Boj_5014 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int[] startlink;
    static int F, S, G, U, D;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        F = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());
        G = Integer.parseInt(st.nextToken());
        U = Integer.parseInt(st.nextToken());
        D = Integer.parseInt(st.nextToken());

        startlink = new int[F + 1];
        Arrays.fill(startlink, 1, F + 1, -1);

        bfs(S);

        System.out.println(startlink[G] == -1 ? "use the stairs" : startlink[G]);
    }

    public static void bfs(int start) {
        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        startlink[start] = 0;

        while (!q.isEmpty()) {
            int now = q.poll();
            while (now + U <= F && startlink[now + U] == -1) {
                startlink[now + U] = startlink[now] + 1;
                q.add(now + U);
            }
            while (now - D >= 1 && startlink[now - D] == -1) {
                startlink[now - D] = startlink[now] + 1;
                q.add(now - D);
            }
        }
    }
}
