import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Boj_1916 {
    static class City implements Comparable<City> {
        int cityNum;
        int weight;

        public City(int cityNum, int weight) {
            this.cityNum = cityNum;
            this.weight = weight;
        }

        @Override
        public int compareTo(City c) {
            return this.weight - c.weight;
        }
    }

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static ArrayList<City>[] cites;
    static int[] dist;
    static int N, M, A, B;

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());

        dist = new int[N + 1];
        cites = new ArrayList[N + 1];

        for (int i = 1; i <= N; i++) {
            dist[i] = Integer.MAX_VALUE;
        }

        for (int i = 1; i <= N; i++) {
            cites[i] = new ArrayList<>();
        }

        for (int i = 1; i <= M; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            cites[from].add(new City(to, weight));
        }

        st = new StringTokenizer(br.readLine());
        A = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());
        bfs(A);

        System.out.println(dist[B]);
    }

    static void bfs(int start) {
        PriorityQueue<City> pq = new PriorityQueue<>();
        pq.add(new City(start, 0));
        dist[A] = 0;

        while (!pq.isEmpty()) {
            City now = pq.poll();
            if (dist[now.cityNum] < now.weight) {
                continue;
            }
            for (City next : cites[now.cityNum]) {
                if (dist[next.cityNum] > dist[now.cityNum] + next.weight) {
                    dist[next.cityNum] = dist[now.cityNum] + next.weight;
                    pq.add(new City(next.cityNum, dist[next.cityNum]));
                }
            }
        }
    }
}
