import java.io.*;
import java.util.*;

public class Boj_30980 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static Character[][] map;
    static int N, M;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new Character[N * 3][M * 8];
        for (int y = 0; y < N * 3; y++) {
            String input = br.readLine();
            for (int x = 0; x < M * 8; x++) {
                map[y][x] = input.charAt(x);
            }
        }

        for (int y = 0; y < N; y++) {
            int startY = (y * 3) + 1;
            for (int x = 0; x < M; x++) {
                int startX = (x * 8) + 1;
                int leftOperand = map[startY][startX] - '0';
                int operator = map[startY][startX + 1];
                int rightOperand = map[startY][startX + 2] - '0';
                int result;
                int resultLength = 1;
                if (!Character.isDigit(map[startY][startX + 5])) {
                    result = map[startY][startX + 4] - '0';
                } else {
                    result = Integer.parseInt(map[startY][startX + 4].toString().concat(map[startY][startX + 5].toString()));
                    resultLength = 2;
                }
                if (operator == '+') {
                    if (leftOperand + rightOperand == result) {
                        map[startY][startX - 1] = '*';
                        int last = 5;
                        if (resultLength == 2) {
                            last = 6;
                            map[startY][startX + 6] = '*';
                        } else {
                            map[startY][startX + 5] = '*';
                        }
                        for (int i = startX; i < startX + last; i++) {
                            map[startY + 1][i] = '*';
                        }
                        for (int i = startX; i < startX + last; i++) {
                            map[startY - 1][i] = '*';
                        }
                        continue;
                    }
                    map[startY - 1][startX + 2] = '/';
                    map[startY][startX + 1] = '/';
                    map[startY + 1][startX] = '/';
                    continue;
                }
                if (leftOperand - rightOperand == result) {
                    map[startY][startX - 1] = '*';
                    int last = 5;
                    if (resultLength == 2) {
                        last = 6;
                        map[startY][startX + 6] = '*';
                    } else {
                        map[startY][startX + 5] = '*';
                    }
                    for (int i = startX; i < startX + last; i++) {
                        map[startY + 1][i] = '*';
                    }
                    for (int i = startX; i < startX + last; i++) {
                        map[startY - 1][i] = '*';
                    }
                    continue;
                }
                map[startY - 1][startX + 2] = '/';
                map[startY][startX + 1] = '/';
                map[startY + 1][startX] = '/';
                continue;
            }
        }

        for (int y = 0; y < N * 3; y++) {
            for (int x = 0; x < M * 8; x++) {
                sb.append(map[y][x]);
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }
}
