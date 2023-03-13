import java.util.*;
import java.io.*;

public class Boj_13549 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int[] dist = new int[100_001];
    static int oldSister, youngSister;

    public static void main(String[] args) throws IOException{
        st = new StringTokenizer(br.readLine());
        oldSister = Integer.parseInt(st.nextToken());
        youngSister = Integer.parseInt(st.nextToken());

        Arrays.fill(dist, -1);

        bfs(oldSister);
        System.out.println(dist[youngSister]);
    }

    static void bfs(int start){
        Queue<Integer> q = new LinkedList<>();
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
            if(now * 2 >= 0 && now * 2 <= 100_000 && (dist[now * 2] == -1 || dist[now * 2] > dist[now])){
                dist[now * 2] = dist[now];
                q.add(now * 2);
            }
        }
    }
}
