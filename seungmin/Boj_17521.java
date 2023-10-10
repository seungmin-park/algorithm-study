import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class Boj_17521 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static BigInteger w, c = BigInteger.ZERO;
    static int n;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        w = new BigInteger(st.nextToken());

        int now = Integer.parseInt(br.readLine());

        for (int i = 1; i < n; i++) {
            int next = Integer.parseInt(br.readLine());
            if (now <= next) {
                c = c.add(w.divide(BigInteger.valueOf(now)));
                w = w.remainder(BigInteger.valueOf(now));
            } else {
                w = w.add(c.multiply(BigInteger.valueOf(now)));
                c = BigInteger.ZERO;
            }
            now = next;
        }
        w = w.add(c.multiply(BigInteger.valueOf(now)));

        System.out.println(w);
    }
}
