import java.io.*;
import java.util.*;

public class Boj_1976 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int[][] cities;
    static int N, M;

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        cities = new int[N + 1][N + 1];

        for (int col = 1; col <= N; col++) {
            st = new StringTokenizer(br.readLine());
            for (int row = 1; row <= N; row++) {
                cities[col][row] = Integer.parseInt(st.nextToken());
                if(cities[col][row] == 0){
                    cities[col][row] = Integer.MAX_VALUE;
                }
            }
        }

        for (int k = 1; k <= N; k++) {
            for (int a = 1; a <= N; a++) {
                for (int b = 1; b <= N; b++) {
                    if (cities[a][k] == Integer.MAX_VALUE || cities[k][b] == Integer.MAX_VALUE) {
                        continue;
                    }
                    cities[a][b] = Math.min(cities[a][b], cities[a][k] + cities[k][b]);
                }
            }
        }

        st = new StringTokenizer(br.readLine());
        int from = Integer.parseInt(st.nextToken());
        int to = 0;
        while (st.hasMoreTokens()) {
            to = Integer.parseInt(st.nextToken());
            if(from == to){
                continue;
            }
            if (cities[from][to] == Integer.MAX_VALUE) {
                System.out.println("NO");
                return;
            }
            from = to;
        }

        System.out.println("YES");
    }
}
