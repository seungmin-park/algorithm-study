import java.io.*;
import java.util.*;

public class Boj_1972 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static Set<String> cand;

    public static void main(String[] args) throws IOException {
        String input;
        Test: while (!(input = br.readLine()).equals("*")) {
            int size = input.length();
            for(int d = 1; d <= size - 1; d++){
                cand = new HashSet<>();
                for(int i = 0; i < size - d; i++){
                    System.out.println(d  + ": "+ input.substring(i, i+ 1).concat(input.substring(i + d, i + d + 1)));
                    if (cand.contains(input.substring(i, i+ 1).concat(input.substring(i + d, i + d + 1)))) {
                        sb.append(input).append(" is NOT surprising.").append("\n");
                        continue Test;
                    }
                    cand.add(input.substring(i, i+ 1).concat(input.substring(i + d, i + d + 1)));
                }
            }

            sb.append(input).append(" is surprising.").append("\n");
        }

        System.out.println(sb);
    }
}
