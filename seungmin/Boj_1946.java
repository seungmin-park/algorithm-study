import java.io.*;
import java.util.*;

public class Boj_1946 {
    static class Recruit {
        int doc, interview;

        Recruit(int doc, int interview) {
            this.doc = doc;
            this.interview = interview;
        }
    }

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static boolean[] fails;
    static List<Recruit> recruits;
    static int T, N;

    public static void main(String[] args) throws IOException {
        T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            N = Integer.parseInt(br.readLine());
            recruits = new ArrayList<>();
            fails = new boolean[N];
            int ans = 1;
            for (int i = 1; i <= N; i++) {
                st = new StringTokenizer(br.readLine());
                int doc = Integer.parseInt(st.nextToken());
                int interview = Integer.parseInt(st.nextToken());

                recruits.add(new Recruit(doc, interview));
            }

            recruits.sort((r1, r2) -> r1.doc - r2.doc);
            int minInterview = recruits.get(0).interview;
            for (int i = 1; i < N; i++) {
                Recruit now = recruits.get(i);
                if (now.interview < minInterview) {
                    ans++;
                    minInterview = now.interview;
                }
            }

            sb.append(ans).append("\n");
        }

        System.out.println(sb);
    }
}
