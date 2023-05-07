import java.io.*;
import java.util.*;

public class Boj_20546 {
    static class Person {
        int money, cnt;

        Person(int money, int cnt) {
            this.money = money;
            this.cnt = cnt;
        }
    }

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int[] costs = new int[14 + 1];
    static int N, up, down;

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= 14; i++) {
            costs[i] = Integer.parseInt(st.nextToken());
        }
        Person j = new Person(N, 0);
        Person s = new Person(N, 0);
        j.cnt = j.money / costs[1];
        j.money = j.money % costs[1];

        for (int i = 2; i < 14; i++) {
            if (costs[i] <= j.money) {
                j.cnt += j.money / costs[i];
                j.money = j.money % costs[i];
            }
            if (costs[i] > costs[i - 1]) {
                up++;
                down = 0;
            }
            if (costs[i] < costs[i - 1]) {
                down++;
                up = 0;
            }
            if (costs[i] <= s.money && down >= 3) {
                s.cnt += s.money / costs[i];
                s.money = s.money % costs[i];
            }
            if (up >= 3 && s.cnt > 0) {
                s.money += costs[i] * s.cnt;
                s.cnt = 0;
            }
        }
        int jSale = j.cnt * costs[14] + j.money;
        int sSale = s.cnt * costs[14] + s.money;
        System.out.println(jSale == sSale ? "SAMESAME" : (jSale > sSale ? "BNP" : "TIMING"));
    }
}
