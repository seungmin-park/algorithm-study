import java.io.*;
import java.util.*;

public class Boj_21736 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static String[] campus;
    static final char EMPTY_AREA = 'O';
    static final char WALL = 'X';
    static final char TARGET = 'I';
    static final char PERSON = 'P';
    static boolean[][] visited;
    static int[][] dir = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };
    static int N, M, startX, startY, ans;

    public static void main(String[] args) throws IOException {
        input();
        process();
    }

    private static void input() throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        init();
    }

    private static void init() throws IOException {
        campus = new String[N];
        visited = new boolean[N][M];

        for (int col = 0; col < N; col++) {
            campus[col] = br.readLine();
            searchTarget(col);
        }
    }

    private static void searchTarget(int col) {
        for (int row = 0; row < M; row++) {
            if (campus[col].charAt(row) == TARGET) {
                startY = col;
                startX = row;
            }
        }
    }

    private static void process() {
        bfs(startY, startX);
        System.out.println(ans == 0 ? "TT" : ans);
    }

    static void bfs(int startY, int startX) {
        Queue<Integer> q = new LinkedList<>();
        q.add(startY);
        q.add(startX);
        visited[startY][startX] = true;

        while (!q.isEmpty()) {
            int nowY = q.poll();
            int nowX = q.poll();
            for (int i = 0; i < 4; i++) {
                int dy = nowY + dir[i][0];
                int dx = nowX + dir[i][1];
                if (validateMovableArea(dy, dx))
                    continue;
                checkPerson(dy, dx);
                q.add(dy);
                q.add(dx);
                visited[dy][dx] = true;
            }
        }
    }

    private static boolean validateMovableArea(int y, int x) {
        if (validateCampusArea(y, x))
            return true;
        if (validateDuplicateVisit(y, x))
            return true;
        if (validateWall(y, x))
            return true;
        return false;
    }

    private static boolean validateCampusArea(int y, int x) {
        return (y < 0 || y > N - 1 || x < 0 || x > M - 1);
    }

    private static boolean validateDuplicateVisit(int y, int x) {
        return visited[y][x];
    }

    private static boolean validateWall(int y, int x) {
        return campus[y].charAt(x) == WALL;
    }

    private static void checkPerson(int y, int x) {
        if (campus[y].charAt(x) == PERSON)
            ans++;
    }
}