import java.io.*;
import java.util.*;

public class Boj_1431 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static String[] serial;
    static int N;

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        serial = new String[N];
        for (int i = 0; i < N; i++) {
            serial[i] = br.readLine();
        }

        Arrays.sort(serial, (s1, s2) -> {
            if (s1.length() == s2.length()) {
                int sum1 = 0;
                int sum2 = 0;
                for (int i = 0; i < s1.length(); i++) {
                    if (s1.charAt(i) >= '0' && s1.charAt(i) <= '9') {
                        sum1 += s1.charAt(i) - '0';
                    }
                }

                for (int i = 0; i < s2.length(); i++) {
                    if (s2.charAt(i) >= '0' && s2.charAt(i) <= '9') {
                        sum2 += s2.charAt(i) - '0';
                    }
                }

                if (sum1 == sum2) {
                    return s1.compareTo(s2);
                }
                return sum1 - sum2;
            }
            return s1.length() - s2.length();
        });

        for (String s : serial) {
            System.out.println(s);
        }
    }
}
