import java.io.*;
import java.util.*;

public class Boj_18870 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static Map<Integer, Integer> loc = new HashMap<>();
    static Set<Integer> coordinate = new TreeSet<>();
    static int[] coordinates;
    static int N;

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        coordinates = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int coord = Integer.parseInt(st.nextToken());
            coordinates[i] = coord;
            coordinate.add(coord);
        }

        Integer[] arr = coordinate.toArray(new Integer[0]);
        for (int i = 0; i < arr.length; i++) {
            loc.put(arr[i], i);
        }

        for (int i = 0; i < N; i++) {
            sb.append(loc.get(coordinates[i])).append(" ");
        }

        System.out.println(sb);
    }
}
