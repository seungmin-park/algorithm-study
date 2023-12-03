import java.io.*;

public class Boj_9656 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int N;
    static String[] loser = new String[1_001];

    public static void main(String[] args) throws IOException {
        for (int i = 1; i <= 1_000; i = i + 2) {
            loser[i] = "SK";
        }

        for (int i = 2; i <= 1_000; i = i + 2) {
            loser[i] = "CY";
        }

        N = Integer.parseInt(br.readLine());
        System.out.println(loser[N] == "CY" ? "SK" : "CY");
    }
}
