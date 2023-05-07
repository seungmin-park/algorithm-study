import java.io.*;
import java.util.*;

public class Boj_21608 {
    static class Point implements Comparable<Point> {
        int x, y, likeCnt, emptyCnt;

        Point(int y, int x, int likeCnt, int emptyCnt) {
            this.y = y;
            this.x = x;
            this.likeCnt = likeCnt;
            this.emptyCnt = emptyCnt;
        }

        @Override
        public int compareTo(Point p) {
            if (this.likeCnt != p.likeCnt) {
                return p.likeCnt - this.likeCnt;
            }
            if (this.emptyCnt != p.emptyCnt) {
                return p.emptyCnt - this.emptyCnt;
            }
            if (this.y != p.y) {
                return this.y - p.y;
            }
            return this.x - p.x;
        }
    }

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int[][] dir = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };
    static int[][] school;
    static Map<Integer, List<Integer>> like = new LinkedHashMap<>();
    static int N, ans;

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        school = new int[N + 1][N + 1];
        for (int i = 1; i <= N * N; i++) {
            st = new StringTokenizer(br.readLine());
            int student = Integer.parseInt(st.nextToken());
            List<Integer> l = new ArrayList<>();
            for (int j = 1; j <= 4; j++) {
                l.add(Integer.parseInt(st.nextToken()));
            }
            like.put(student, l);
        }

        for (int student : like.keySet()) {
            List<Point> p = new ArrayList<>();
            for (int col = 1; col <= N; col++) {
                for (int row = 1; row <= N; row++) {
                    if (school[col][row] != 0)
                        continue;
                    int likeCnt = 0;
                    int emptyCnt = 0;
                    for (int d = 0; d < 4; d++) {
                        int dy = col + dir[d][0];
                        int dx = row + dir[d][1];
                        if (dy < 1 || dy > N || dx < 1 || dx > N)
                            continue;
                        if (like.get(student).contains(school[dy][dx]))
                            likeCnt++;
                        else if (school[dy][dx] == 0)
                            emptyCnt++;
                    }
                    p.add(new Point(col, row, likeCnt, emptyCnt));
                }
            }

            Collections.sort(p);
            Point c = p.get(0);
            school[c.y][c.x] = student;
        }

        for (int col = 1; col <= N; col++) {
            for (int row = 1; row <= N; row++) {
                int likeCnt = 0;
                int student = school[col][row];
                for (int d = 0; d < 4; d++) {
                    int dy = col + dir[d][0];
                    int dx = row + dir[d][1];
                    if (dy < 1 || dy > N || dx < 1 || dx > N)
                        continue;
                    if (like.get(student).contains(school[dy][dx]))
                        likeCnt++;
                }
                if (likeCnt == 4) {
                    ans += 1000;
                } else if (likeCnt == 3) {
                    ans += 100;
                } else if (likeCnt == 2) {
                    ans += 10;
                } else if (likeCnt == 1) {
                    ans += 1;
                }
            }
        }
        System.out.println(ans);
    }
}
