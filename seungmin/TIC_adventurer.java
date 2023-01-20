import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class TIC_adventurer {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int N, group;
    static int[] guild;

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        guild = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            guild[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(guild);
        int cnt = 0;
        for (int adventurer : guild) {
            cnt++;
            if (cnt >= adventurer) {
                group++;
                cnt = 0;
            }
        }

        System.out.println(group);
    }
}
