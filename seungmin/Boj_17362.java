import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Boj_17362 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int N;

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        int result = N % 8;
        if (result == 0) {
            System.out.println(2);
        } else if (result == 7) {
            System.out.println(3);
        } else if (result == 6) {
            System.out.println(4);
        } else {
            System.out.println(result);
        }
    }
}