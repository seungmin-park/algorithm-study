import java.io.*;
import java.util.*;

public class Boj_21276 {
    static class Person {
        String name;
        int indeg;

        Person(String name, int indeg) {
            this.name = name;
            this.indeg = indeg;
        }
    }

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static Map<String, Integer> indeg = new TreeMap<>();
    static Map<String, List<String>> ans = new TreeMap<>();
    static Map<String, List<String>> tree = new TreeMap<>();
    static int N, M, root;

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            String name = st.nextToken();
            ans.put(name, new ArrayList<>());
            tree.put(name, new ArrayList<>());
            indeg.put(name, 0);
        }

        M = Integer.parseInt(br.readLine());
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            String child = st.nextToken();
            String parent = st.nextToken();

            indeg.put(child, indeg.get(child) + 1);
            tree.get(parent).add(child);
        }

        bfs();
        for (String parent : ans.keySet()) {
            sb.append(parent).append(" ").append(ans.get(parent).size());
            Collections.sort(ans.get(parent));
            for (String child : ans.get(parent)) {
                sb.append(" ").append(child);
            }
            sb.append("\n");
        }
        
        System.out.println(sb);
    }

    static void bfs() {
        Queue<String> q = new LinkedList<>();
        for (String key : indeg.keySet()) {
            if (indeg.get(key) == 0) {
                root++;
                q.add(key);
            }
        }
        sb.append(root).append("\n");
        for (String root : q) {
            sb.append(root).append(" ");
        }
        sb.append("\n");

        while (!q.isEmpty()) {
            String parent = q.poll();
            for (String child : tree.get(parent)) {
                indeg.put(child, indeg.get(child) - 1);
                if (indeg.get(child) == 0) {
                    ans.get(parent).add(child);
                    q.add(child);
                }
            }
        }
    }
}
