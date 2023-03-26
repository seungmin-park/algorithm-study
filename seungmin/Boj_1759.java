import java.util.*;
import java.io.*;

public class Boj_1759 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static boolean[] isUsed = new boolean[27];
    static int[] alphabets = new int[27];
    static int[] selected;
    static int L, C;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        L = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        selected = new int[L];

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= C; i++) {
            int now = st.nextToken().charAt(0) - 'a' + 1;
            alphabets[now]++;
        }

        func(1, 0, 0, 1);
        System.out.println(sb);
    }

    static void func(int k, int vowel, int consonant, int idx) {
        if (k == L + 1) {
            if (vowel >= 1 && consonant >= 2) {
                for (int select : selected) {
                    sb.append((char)(select - 1 +'a'));
                }
                sb.append("\n");
            }
            return;
        }

        for (int i = idx; i <= 26; i++) {
            if (alphabets[i] == 0 || isUsed[i])
                continue;
            isUsed[i] = true;
            alphabets[i]--;
            selected[k - 1] = i;
            if (i == 1 || i == 5 || i == 9 || i == 15 || i == 21)
                func(k + 1, vowel + 1, consonant, i);
            else
                func(k + 1, vowel, consonant + 1, i);
            selected[k - 1] = 0;
            isUsed[i] = false;
            alphabets[i]++;
        }
    }
}
