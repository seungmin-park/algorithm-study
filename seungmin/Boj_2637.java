import java.io.*;
import java.util.*;

public class Boj_2637 {
    static class Product {
        int num, weight;

        Product(int num, int weight) {
            this.num = num;
            this.weight = weight;
        }
    }

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static List<Product>[] graph;
    static int[] indeg, ans;
    static int N, M;

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());

        indeg = new int[N + 1];
        ans = new int[N + 1];
        graph = new ArrayList[N + 1];

        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 1; i <= M; i++) {
            st = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken());
            int pre = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            graph[num].add(new Product(pre, weight));
            indeg[pre]++;
        }

        bfs();

        for (int i = 1; i <= N; i++) {
            if (graph[i].size() == 0) {
                sb.append(i).append(" ").append(ans[i]).append("\n");
            }
        }

        System.out.println(sb);
    }

    static void bfs() {
        Queue<Integer> q = new LinkedList<>();
        q.add(N);
        ans[N] = 1;

        while (!q.isEmpty()) {
            int now = q.poll();
            for (Product next : graph[now]) {
                ans[next.num] += ans[now] * next.weight;
                indeg[next.num]--;
                if (indeg[next.num] == 0) {
                    q.add(next.num);
                }
            }
        }
    }
}
