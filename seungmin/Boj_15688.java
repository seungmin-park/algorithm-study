import java.io.*;
import java.util.*;

public class Boj_15688 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringBuilder sb = new StringBuilder();
    static int[] arr;
    static int N;

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        arr = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(arr, 1, N + 1);

        for (int i = 1; i <= N; i++) {
            sb.append(arr[i]).append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
    }
}
