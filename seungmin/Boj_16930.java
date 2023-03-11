import java.util.*;
import java.io.*;

public class Boj_16930 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static String[] graph;
    static int[][] dir = {{1,0},{-1,0},{0,1},{0,-1}};
    static int[][] distance;
    static int N, M, K, startX, startY, goalX, goalY;

    public static void main(String[] args) throws IOException{
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        distance = new int[N + 1][M + 1];
        graph = new String[N + 1];

        for(int col = 1; col <=N; col++){
            for(int row = 1; row <=M; row++){
                distance[col][row] = -1;
            }
        }

        for(int i = 1; i <=N; i++){
            graph[i] = br.readLine();
        }

        st = new StringTokenizer(br.readLine());
        startY = Integer.parseInt(st.nextToken());
        startX = Integer.parseInt(st.nextToken());
        goalY = Integer.parseInt(st.nextToken());
        goalX = Integer.parseInt(st.nextToken());

        bfs(startY, startX);
        System.out.println(distance[goalY][goalX]);
    }

    static void bfs(int startY, int startX){
        Queue<Integer> q = new LinkedList<>();
        q.add(startY);
        q.add(startX);
        distance[startY][startX] = 0;
        while(!q.isEmpty()){
            int nowY = q.poll();
            int nowX = q.poll();
            for(int i = 0; i <4; i++){
                for(int k = 1; k <= K; k++){
                    int dy = nowY + dir[i][0] * k;
                    int dx = nowX + dir[i][1] * k;
                    if(dy < 1 || dy > N || dx < 1 || dx > M) break;
                    if(graph[dy].charAt(dx-1) == '#') break;
                    if(distance[dy][dx] == -1 || distance[dy][dx] > distance[nowY][nowX] + 1){
                        distance[dy][dx] = distance[nowY][nowX] + 1;
                        q.add(dy);
                        q.add(dx);
                    }
                    if(distance[dy][dx] < distance[nowY][nowX] + 1){
                        break;
                    }
                }
            }
        }
    }
}
