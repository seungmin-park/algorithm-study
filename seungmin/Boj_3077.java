import java.io.*;
import java.util.*;

public class Boj_3077 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static Map<String, Integer> map = new HashMap<>();
    static String[] arr;
    static int N, ans;

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        arr = new String[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            map.put(st.nextToken(), i);
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = st.nextToken();
        }

        for (int i = 0; i < N - 1; i++) {
            for (int j = i + 1; j < N; j++) {
                String first = arr[i];
                String second = arr[j];
                if (map.get(first) < map.get(second)) {
                    ans++;
                }
            }
        }

        sb.append(ans).append("/").append((N * (N - 1)) / 2);
        System.out.println(sb);
    }
}
