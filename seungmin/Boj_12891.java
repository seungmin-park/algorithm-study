import java.io.*;
import java.util.*;

public class Boj_12891 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static String input;
    static int[] alphabets = new int[26];
    static int S, P, ans, A, C, G, T;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        S = Integer.parseInt(st.nextToken());
        P = Integer.parseInt(st.nextToken());

        input = br.readLine();
        st = new StringTokenizer(br.readLine());
        A = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        G = Integer.parseInt(st.nextToken());
        T = Integer.parseInt(st.nextToken());
        for (int i = 0; i < P; i++) {
            alphabets[input.charAt(i) - 'A']++;
        }
        if (alphabets[0] >= A && alphabets['C' - 'A'] >= C && alphabets['G' - 'A'] >= G && alphabets['T' - 'A'] >= T) {
            ans = 1;
        }

        for (int i = P; i < S; i++) {
            alphabets[input.charAt(i - P) - 'A']--;
            alphabets[input.charAt(i) - 'A']++;
            if (alphabets[0] >= A && alphabets['C' - 'A'] >= C && alphabets['G' - 'A'] >= G && alphabets['T' - 'A'] >= T) {
                ans++;
            }
        }

        System.out.println(ans);
    }
}
