import java.io.*;
import java.util.*;

public class Boj_3005 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static List<String> words = new ArrayList<>();
    static String[] map;
    static int N, M;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new String[N];
        for (int i = 0; i < N; i++) {
            map[i] = br.readLine();
        }

        for (int y = 0; y < N; y++) {
            StringBuilder sb = new StringBuilder();
            for (int x = 0; x < M; x++) {
                if (map[y].charAt(x) == '#') {
                    if (sb.length() > 1) {
                        words.add(sb.toString());
                    }
                    sb = new StringBuilder();
                    continue;
                }
                sb.append(map[y].charAt(x));
            }
            if (sb.length() > 1) {
                words.add(sb.toString());
            }
            sb = new StringBuilder();
        }

        for (int x = 0; x < M; x++) {
            StringBuilder sb = new StringBuilder();
            for (int y = 0; y < N; y++) {
                if (map[y].charAt(x) == '#') {
                    if (sb.length() > 1) {
                        words.add(sb.toString());
                    }
                    sb = new StringBuilder();
                    continue;
                }
                sb.append(map[y].charAt(x));
            }
            if (sb.length() > 1) {
                words.add(sb.toString());
            }
            sb = new StringBuilder();
        }

        Collections.sort(words);

        System.out.println(words.get(0));
    }
}
