import java.io.*;
import java.util.*;

public class Boj_25206 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static Map<String, Double> score = new HashMap<>();
    static int N = 20;
    static double ans, sum;

    public static void main(String[] args) throws IOException {
        score.put("A+", 4.5);
        score.put("A0", 4.0);
        score.put("B+", 3.5);
        score.put("B0", 3.0);
        score.put("C+", 2.5);
        score.put("C0", 2.0);
        score.put("D+", 1.5);
        score.put("D0", 1.0);
        score.put("F", 0.0);
        
        for (int i = 1; i <= 20; i++) {
            st = new StringTokenizer(br.readLine());
            String subjectName = st.nextToken();
            double subjectCredit = Double.parseDouble(st.nextToken());
            String subjectScore = st.nextToken();
            if (subjectScore.equals("P")) {
                N--;
                continue;
            }
            sum += subjectCredit;

            ans += subjectCredit * score.get(subjectScore);
        }

        System.out.println(String.format("%6f", ans / sum));
    }
}