import java.io.*;
import java.util.*;

public class Boj_1697 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int[] dist = new int[100_001];
    static int N, K;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        for(int i = 0; i <= 100_000; i++){
            dist[i] = -1;
        }

        bfs(N);

        System.out.println(dist[K]);
    }

    static void bfs(int start){
        Queue<Integer> q =  new LinkedList<>();
        q.add(start);
        dist[start] = 0;
        while(!q.isEmpty()){
            int now = q.poll();
            if(now - 1 >= 0 && now - 1 <= 100_000 && (dist[now - 1] == -1 || dist[now - 1] > dist[now] + 1)){
                dist[now - 1] = dist[now] + 1;
                q.add(now - 1);
            }
            if(now + 1 >= 0 && now + 1 <= 100_000 && (dist[now + 1] == -1 || dist[now + 1] > dist[now] + 1)){
                dist[now + 1] = dist[now] + 1;
                q.add(now + 1);
            }
            if(now * 2 >= 0 && now * 2 <= 100_000 && (dist[now * 2] == -1 || dist[now * 2] > dist[now] + 1)){
                dist[now * 2] = dist[now] + 1;
                q.add(now * 2);
            }
        }
    }
}
