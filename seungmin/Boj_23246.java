import java.io.*;
import java.util.*;

public class Boj_23246 {
    static class Player {
        int num, multiply, sum;

        Player(int num, int multiply, int sum) {
            this.num = num;
            this.multiply = multiply;
            this.sum = sum;
        }
    }

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static Player[] players;
    static int n;

    public static void main(String[] args) throws IOException {
        n = Integer.parseInt(br.readLine());
        players = new Player[n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken());
            int lead = Integer.parseInt(st.nextToken());
            int speed = Integer.parseInt(st.nextToken());
            int boll = Integer.parseInt(st.nextToken());
            players[i] = new Player(num, lead * speed * boll, lead + speed + boll);
        }

        Arrays.sort(players, (p1, p2) -> {
            if (p1.multiply != p2.multiply) {
                return p1.multiply - p2.multiply;
            }
            if (p1.sum != p2.sum) {
                return p1.sum - p2.sum;
            }
            return p1.num - p2.num;
        });

        for (int i = 0; i < 3; i++) {
            sb.append(players[i].num).append(" ");
        }

        System.out.println(sb);
    }
}
