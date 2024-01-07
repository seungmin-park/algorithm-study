import java.io.*;
import java.util.*;

public class Boj_22233 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static Set<String> keywords = new HashSet<>();
    static int N, M;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        for(int i = 1; i <= N; i++){
            keywords.add(br.readLine());
        }

        for(int i = 1; i <= M; i++){
            int cnt = 0;
            int size = keywords.size();
            st =  new StringTokenizer(br.readLine(), ",");
            while (st.hasMoreTokens()) {
                String keyword = st.nextToken();
                if(keywords.contains(keyword)){
                    cnt++;
                    keywords.remove(keyword);
                }
            }
            sb.append(size - cnt).append("\n");
        }

        System.out.println(sb);
    }
}
