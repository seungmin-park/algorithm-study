import java.io.*;
import java.util.*;

public class Boj_1647 {
    static class Town {
        int from, to, weight;

        Town(int from, int to, int weight) {
            this.from = from;
            this.to = to;
            this.weight = weight;
        }
    }

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static List<Town> towns = new ArrayList<>();
    static int[] parent;
    static int N, M, ans;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        parent = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            parent[i] = i;
        }

        for (int i = 1; i <= M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            towns.add(new Town(a, b, weight));
        }

        Collections.sort(towns, (t1, t2) -> t1.weight - t2.weight);

        int last = 0;
        int loadCnt = 0;
        for (Town town : towns) {
            if (loadCnt == N - 1) {
                break;
            }
            if (find(town.from) == find(town.to)) {
                continue;
            }
            union(town.from, town.to);
            last = town.weight;
            ans += town.weight;
            loadCnt++;
        }

        bw.write(new StringBuilder().append(ans - last).toString());
        bw.flush();
    }

    static int find(int num) {
        if (num == parent[num]) {
            return num;
        }

        return parent[num] = find(parent[num]);
    }

    static void union(int from, int to) {
        int fromParent = find(from);
        int toParent = find(to);
        parent[toParent] = fromParent;
    }
}
