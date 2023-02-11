import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Boj_9663 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int[] queenLoc;
    static int N, ans;

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());

        queenLoc = new int[N + 1];

        func(1);
        System.out.println(ans);
    }

    static void func(int row) {
        if (row == N + 1) {
            ans++;
            return;
        }

        for (int col = 1; col <= N; col++) {
            queenLoc[row] = col;
            if (possible(row)) {
                func(row + 1);
            }
            queenLoc[row] = 0;
        }
    }

    static boolean possible(int row) {
        for (int depth = 1; depth < row; depth++) {
            if (queenLoc[depth] == queenLoc[row]) {
                return false;
            }
            if (depth - queenLoc[depth] == row - queenLoc[row]) {
                return false;
            }
            if (depth + queenLoc[depth] == row + queenLoc[row]) {
                return false;
            }
        }
        return true;
    }
}
