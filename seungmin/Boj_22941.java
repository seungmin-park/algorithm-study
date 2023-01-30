import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_22941 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static long heroHP, heroATK, monsterHP, monsterATK, P, S, heroCnt, monsterCnt;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        heroHP = Integer.parseInt(st.nextToken());
        heroATK = Integer.parseInt(st.nextToken());
        monsterHP = Integer.parseInt(st.nextToken());
        monsterATK = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        P = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());

        heroCnt = heroHP % monsterATK > 0 ? (heroHP / monsterATK) + 1 : heroHP / monsterATK;

        if (heroATK >= monsterHP) {
            monsterCnt = 1;
        } else if ((monsterHP - P) % heroATK == 0 || (monsterHP - P) % heroATK + P > heroATK) {
            monsterHP += S;
        }
        monsterCnt = (long) Math.ceil((double) monsterHP / heroATK);

        System.out.println(heroCnt >= monsterCnt ? "Victory!" : "gg");
    }
}
