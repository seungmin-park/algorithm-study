import java.io.*;

public class Boj_31090 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static int N;

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        for (int i = 1; i <= N; i++) {
            int now = Integer.parseInt(br.readLine());
            int condition = now % 100;

            if ((now + 1) % condition == 0) {
                sb.append("Good").append("\n");
                continue;
            }
            sb.append("Bye").append("\n");
        }

        System.out.println(sb);
    }
}
