import java.io.*;
import java.util.*;

public class Boj_11779 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static List<City>[] cities;
    static List<Integer> routes = new ArrayList<>();
    static int[] dist, preNum;
    static int n, m, start, end;
    static class City implements Comparable<City>{
        int num, weight;

        City(int num, int weight){
            this.num = num;
            this.weight = weight;
        }

        @Override
        public int compareTo(City c){
            return this.weight - c.weight;
        }
    }

    public static void main(String[] args) throws IOException {
        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());

        dist = new int[n + 1];
        preNum = new int[n + 1];
        cities = new ArrayList[n + 1];

        for(int i = 1; i <=n; i++){
            cities[i] = new ArrayList<>();
            dist[i] = Integer.MAX_VALUE;
        }

        for(int i =1; i <=m; i++){
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            cities[from].add(new City(to, weight));
        }

        st = new StringTokenizer(br.readLine());
        start = Integer.parseInt(st.nextToken());
        end = Integer.parseInt(st.nextToken());

        bfs(start);

        routes.add(end);
        int temp = preNum[end];
        while(temp != start){
            routes.add(temp);
            temp = preNum[temp];
        }
        routes.add(start);

        Collections.reverse(routes);

        sb.append(dist[end]).append("\n")
        .append(routes.size()).append("\n");
        for(int route : routes){
            sb.append(route).append(" ");
        }

        System.out.println(sb);
    }

    static void bfs(int start){
        PriorityQueue<City> pq = new PriorityQueue<>();
        pq.add(new City(start, 0));
        dist[start] = 0;
        while(!pq.isEmpty()){
            City now = pq.poll();
            if(dist[now.num] <  now.weight) continue;
            for(City next : cities[now.num]){
                if(dist[next.num] > dist[now.num] + next.weight){
                    dist[next.num] = dist[now.num] + next.weight;
                    pq.add(new City(next.num, dist[next.num]));
                    preNum[next.num] = now.num;
                }
            }
        }
    }
}
