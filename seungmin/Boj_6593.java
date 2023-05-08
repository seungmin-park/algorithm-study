import java.io.*;
import java.util.*;

public class Boj_6593 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static String[][] building;
    static int[][] dir = { { 0, 1, 0 }, { 0, -1, 0 }, { 0, 0, 1 }, { 0, 0, -1 }, { 1, 0, 0 }, { -1, 0, 0 } };
    static int[][][] distance;
    static int L, R, C, startZ, startY, startX, goalZ, goalY, goalX;

    public static void main(String[] args) throws IOException {
        while (true) {
            st = new StringTokenizer(br.readLine());
            L = Integer.parseInt(st.nextToken());
            R = Integer.parseInt(st.nextToken());
            C = Integer.parseInt(st.nextToken());

            if (L == 0 && R == 0 && C == 0) {
                break;
            }

            distance = new int[L + 1][R + 1][C];
            building = new String[L + 1][R + 1];

            for (int z = 1; z <= L; z++) {
                for (int y = 1; y <= R; y++) {
                    String nextLine = br.readLine();
                    if (nextLine.equals("")) {
                        y--;
                        continue;
                    }
                    building[z][y] = nextLine;
                    for (int x = 0; x < C; x++) {
                        distance[z][y][x] = -1;
                        if (building[z][y].charAt(x) == 'S') {
                            startZ = z;
                            startY = y;
                            startX = x;
                        }
                        if (building[z][y].charAt(x) == 'E') {
                            goalZ = z;
                            goalY = y;
                            goalX = x;
                        }
                    }
                }
            }

            bfs();
            if (distance[goalZ][goalY][goalX] == -1) {
                sb.append("Trapped!");
            } else {
                sb.append("Escaped in ").append(distance[goalZ][goalY][goalX]).append(" minute(s).");
            }
            sb.append("\n");

            br.readLine();
        }
        System.out.println(sb);
    }

    static void bfs() {
        Queue<Integer> q = new LinkedList<>();
        q.add(startZ);
        q.add(startY);
        q.add(startX);
        distance[startZ][startY][startX] = 0;

        while (!q.isEmpty()) {
            int nowZ = q.poll();
            int nowY = q.poll();
            int nowX = q.poll();

            for (int i = 0; i < 6; i++) {
                int dz = nowZ + dir[i][0];
                int dy = nowY + dir[i][1];
                int dx = nowX + dir[i][2];
                if (dz < 1 || dz > L || dy < 1 || dy > R || dx < 0 || dx > C - 1)
                    continue;
                if (building[dz][dy].charAt(dx) == '#')
                    continue;
                if (distance[dz][dy][dx] == -1 || distance[dz][dy][dx] > distance[nowZ][nowY][nowX] + 1) {
                    distance[dz][dy][dx] = distance[nowZ][nowY][nowX] + 1;
                    q.add(dz);
                    q.add(dy);
                    q.add(dx);
                }
            }
        }
    }
}
