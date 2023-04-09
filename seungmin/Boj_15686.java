import java.io.*;
import java.util.*;

public class Boj_15686 {
    static class Point{
        int x, y;

        Point(int y, int x){
            this.y = y;
            this.x = x;
        }
    }
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static List<Point> homes = new ArrayList<>();
    static List<Point> chickens = new ArrayList<>();
    static boolean[] isRemoved;
    static int N, M, ans = Integer.MAX_VALUE;


    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        for(int col = 1; col <= N; col++){
            st = new StringTokenizer(br.readLine());
            for(int row = 1; row <= N; row++){
                int now = Integer.parseInt(st.nextToken());
                if(now == 1){
                    homes.add(new Point(col, row));
                    continue;
                }
                if(now == 2){
                    chickens.add(new Point(col, row));
                    continue;
                }
            }
        }

        isRemoved = new boolean[chickens.size()];

        func(0, -1);

        System.out.println(ans);
    }

    static void func(int k, int pre){
        if(chickens.size() - k == M){
            ans = Math.min(ans, getDistance());
            return;
        }

        for(int i = pre + 1; i < chickens.size(); i++){
            if(isRemoved[i]) continue;
            isRemoved[i] = true;
            func(k + 1, i);
            isRemoved[i] = false;
        }
    }

    static int getDistance(){
        int result = 0;
        for(int i = 0; i < homes.size(); i++){
            int temp = Integer.MAX_VALUE;
            for(int j = 0; j < chickens.size(); j++){
                if(isRemoved[j]) continue;
                Point home = homes.get(i);
                Point chicken = chickens.get(j);
                temp = Math.min(temp, Math.abs(home.y - chicken.y) + Math.abs(home.x - chicken.x));
            }
            result += temp;
        }
        return result;
    }
}
