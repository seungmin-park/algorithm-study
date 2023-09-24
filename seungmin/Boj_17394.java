import java.io.*;
import java.util.*;

public class Boj_17394 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static int[] arr;
    static int T, N, A, B;

    public static void main(String[] args) throws IOException {
        T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            A = Integer.parseInt(st.nextToken());
            B = Integer.parseInt(st.nextToken());

            arr = new int[1_000_001];
            Arrays.fill(arr, -1);
            sb.append(bfs()).append("\n");
        }

        System.out.println(sb);
    }

    static int bfs() {
        Queue<Integer> q = new LinkedList<>();
        q.add(N);
        arr[N] = 0;

        while (!q.isEmpty()) {
            int now = q.poll();
            if (A <= now && now <= B) {
                boolean isPrime = true;
                for (int i = 2; i <= Math.sqrt(now); i++) {
                    if (now % i == 0) {
                        isPrime = false;
                        break;
                    }
                }
                if (isPrime) {
                    return arr[now];
                }
            }
            int[] nextCand = { now / 2, now / 3, now + 1, now - 1 };
            for (int i = 0; i < 4; i++) {
                int next = nextCand[i];
                if (next < 1 || next > 1_000_000) {
                    continue;
                }
                if (arr[next] != -1) {
                    continue;
                }
                arr[next] = arr[now] + 1;
                q.add(next);
            }
        }

        return -1;
    }
}
