import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class Boj_29723 {
    static class Grade {
        String name;
        int score;

        Grade(String name, int score) {
            this.name = name;
            this.score = score;
        }
    }

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static Map<String, Integer> grades = new HashMap<>();
    static int N, M, K, min, max;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            String name = st.nextToken();
            int score = Integer.parseInt(st.nextToken());
            grades.put(name, score);
        }

        for (int i = 1; i <= K; i++) {
            String name = br.readLine();
            min += grades.get(name);
            max += grades.get(name);
            grades.remove(name);
        }

        List<Grade> sortedGrades = grades.keySet()
                .stream()
                .map(name -> new Grade(name, grades.get(name)))
                .sorted((g1, g2) -> g1.score - g2.score)
                .collect(Collectors.toList());

        int restCount = M - K;
        int left = 0;
        int right = sortedGrades.size() - 1;
        for (int i = 1; i <= restCount; i++) {
            min += sortedGrades.get(left).score;
            max += sortedGrades.get(right).score;
            left++;
            right--;
        }

        sb.append(min).append(" ").append(max);

        System.out.println(sb);
    }
}
