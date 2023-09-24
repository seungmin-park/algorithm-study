import java.io.*;
import java.util.*;

public class Boj_9205 {
    static class Point {
        int y, x;

        Point(int x, int y) {
            this.y = y;
            this.x = x;
        }
    }

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static List<Integer>[] graph;
    static List<Point> points;
    static boolean[] visited;
    static int t, n;

    public static void main(String[] args) throws IOException {
        t = Integer.parseInt(br.readLine());
        for (int T = 0; T < t; T++) {
            points = new ArrayList<>();
            n = Integer.parseInt(br.readLine());
            visited = new boolean[n + 2];
            graph = new ArrayList[n + 2];
            for (int i = 0; i < n + 2; i++) {
                graph[i] = new ArrayList<>();
            }

            // start
            st = new StringTokenizer(br.readLine());
            points.add(new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));

            // convenience store
            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                points.add(new Point(x, y));
            }

            // end
            st = new StringTokenizer(br.readLine());
            points.add(new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));

            for (int i = 0; i < points.size() - 1; i++) {
                Point from = points.get(i);
                for (int j = i + 1; j < points.size(); j++) {
                    Point to = points.get(j);
                    int dist = Math.abs(from.x - to.x) + Math.abs(from.y - to.y);
                    if (dist > 1_000) {
                        continue;
                    }
                    graph[i].add(j);
                    graph[j].add(i);
                }
            }

            bfs();
            if (visited[n + 1]) {
                sb.append("happy");
            } else {
                sb.append("sad");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }

    static void bfs() {
        Queue<Integer> q = new LinkedList<>();
        q.add(0);
        visited[0] = true;

        while (!q.isEmpty()) {
            int now = q.poll();
            for (int next : graph[now]) {
                if (visited[next]) {
                    continue;
                }

                q.add(next);
                visited[next] = true;
            }
        }
    }
}
