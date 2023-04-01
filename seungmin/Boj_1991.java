import java.io.*;
import java.util.*;

public class Boj_1991 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static Map<String, List<String>> tree = new HashMap<>();
    // static boolean[] visited = new boolean[26];
    static int N;

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            String parent = st.nextToken();
            String child1 = st.nextToken();
            String child2 = st.nextToken();
            List<String> temp = tree.getOrDefault(parent, new ArrayList<>());
            temp.addAll(List.of(child1, child2));
            tree.put(parent, temp);
        }

        pre("A");
        sb.append("\n");
        midean("A");
        sb.append("\n");
        post("A");
        System.out.println(sb);
    }

    static void pre(String start) {
        if(start.equals(".")) return;
        List<String> children = tree.get(start);
        String leftChild = children.get(0);
        String rightChild = children.get(1);
        sb.append(start);
        pre(leftChild);
        pre(rightChild);
    }

    static void midean(String start) {
        if(start.equals(".")) return;
        List<String> children = tree.get(start);
        String leftChild = children.get(0);
        String rightChild = children.get(1);
        midean(leftChild);
        sb.append(start);
        midean(rightChild);
    }

    static void post(String start) {
        if(start.equals(".")) return;
        List<String> children = tree.get(start);
        String leftChild = children.get(0);
        String rightChild = children.get(1);
        post(leftChild);
        post(rightChild);
        sb.append(start);
    }
}
