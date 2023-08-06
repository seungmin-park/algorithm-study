import java.io.*;

public class Boj_2941 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static String[] keywords = { "c=", "c-", "dz=", "d-", "lj", "nj", "s=", "z=" };
    static String target;

    public static void main(String[] args) throws IOException {
        target = br.readLine();
        for (String keyword : keywords) {
            target = target.replaceAll(keyword, "1");
        }

        System.out.println(target.length());
    }
}
