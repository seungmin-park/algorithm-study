import java.io.*;
import java.util.*;

public class Boj_5464 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static Queue<Integer> q = new LinkedList<>();
    static int[] isParked, parkings, cars;
    static int N, M, ans;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        isParked = new int[N + 1];
        parkings = new int[N + 1];
        cars = new int[M + 1];
        for (int i = 1; i <= N; i++) {
            parkings[i] = Integer.parseInt(br.readLine());
        }

        for (int i = 1; i <= M; i++) {
            cars[i] = Integer.parseInt(br.readLine());
        }

        for (int i = 1; i <= M * 2; i++) {
            String command = br.readLine();
            if (command.startsWith("-")) {
                int carNumber = Integer.parseInt(command.split("-")[1]);
                for (int j = 1; j <= N; j++) {
                    if (isParked[j] == carNumber) {
                        isParked[j] = 0;
                        break;
                    }
                }
                if (!q.isEmpty()) {
                    int now = q.poll();
                    for (int j = 1; j <= N; j++) {
                        if (isParked[j] == 0) {
                            isParked[j] = now;
                            ans += parkings[j] * cars[now];
                            break;
                        }
                    }
                }
            } else {
                boolean flag = false;
                for (int j = 1; j <= N; j++) {
                    if (isParked[j] == 0) {
                        isParked[j] = Integer.parseInt(command);
                        ans += parkings[j] * cars[Integer.parseInt(command)];
                        flag = true;
                        break;
                    }
                }
                if (!flag) {
                    q.add(Integer.parseInt(command));
                }
            }
        }

        System.out.println(ans);
    }
}
