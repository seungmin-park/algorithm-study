import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class Boj_2251 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static Set<Integer> ans = new TreeSet<>();
    static boolean[][] visit = new boolean[201][201];
    static int[] limit = new int[3];

    static class Water {
        int[] volumes;

        Water(int[] volumes) {
            this.volumes = new int[3];
            for (int i = 0; i < 3; i++) {
                this.volumes[i] = volumes[i];
            }
        }

        Water move(int form, int to) {
            int[] temp = new int[3];
            for (int i = 0; i < 3; i++) {
                temp[i] = volumes[i];
            }
            // 다 부을 수 없는 경우
            if (temp[to] + temp[form] > limit[to]) {
                temp[form] -= limit[to] - temp[to];
                temp[to] = limit[to];
            } else {
                temp[to] += temp[form];
                temp[form] = 0;
            }
            //다 부을 수 있는 경우
            return new Water(temp);
        }
    }

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 3; i++) {
            limit[i] = Integer.parseInt(st.nextToken());
        }

        bfs();
        for (Integer an : ans) {
            sb.append(an).append(" ");
        }
        System.out.println(sb);
    }

    static void bfs() {
        Queue<Water> q = new LinkedList<>();
        q.add(new Water(new int[]{0, 0, limit[2]}));
        visit[0][0] = true;
        while (!q.isEmpty()) {
            Water now = q.poll();
            if (now.volumes[0] == 0) {
                ans.add(now.volumes[2]);
            }
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    if (i == j) {
                        continue;
                    }
                    if (now.volumes[i] == 0) {
                        continue;
                    }
                    Water after = now.move(i, j);
                    if (!visit[after.volumes[0]][after.volumes[1]]) {
                        visit[after.volumes[0]][after.volumes[1]] = true;
                        q.add(after);
                    }
                }
            }
        }
    }
}
