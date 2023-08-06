import java.io.*;
import java.util.*;

public class Boj_1966 {
    static class Doc {
        int seq, imp;

        Doc(int seq, int imp) {
            this.seq = seq;
            this.imp = imp;
        }
    }

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static int T, N, M;

    public static void main(String[] args) throws IOException {
        T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            List<Doc> docs = new ArrayList<>();
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                int imp = Integer.parseInt(st.nextToken());
                docs.add(new Doc(i, imp));
            }

            print(docs);
        }

        System.out.println(sb);
    }

    static void print(List<Doc> docs) {
        int cnt = 0;
        while (docs.size() != 0) {
            Doc doc = docs.remove(0);
            boolean flag = true;
            for (int i = 0; i < docs.size(); i++) {
                Doc next = docs.get(i);
                if (doc.imp < next.imp) {
                    docs.add(doc);
                    flag = false;
                    break;
                }
            }
            if (flag) {
                cnt++;
                if (doc.seq == M) {
                    sb.append(cnt).append("\n");
                }
            }
        }
    }
}
