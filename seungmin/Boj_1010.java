import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Boj_1010 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static int[][] birge = new int[31][31];
    static int T, N, M;

    public static void main(String[] args) throws IOException {
        T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            for (int i = 1; i <= 30; i++) {
                birge[1][i] = i;
                birge[i][i] = 1;
            }

            for (int n = 2; n <= 29; n++) {
                for (int m = n + 1; m <= 30; m++) {
                    birge[n][m] = birge[n][m - 1] + birge[n - 1][m - 1];
                }
            }
            sb.append(birge[N][M]).append("\n");
        }
        bw.write(sb.toString());
        bw.flush();
    }
}
