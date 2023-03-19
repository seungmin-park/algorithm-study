import java.io.*;
import java.util.*;

public class Boj_10811 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static List<Integer> numbers = new ArrayList<>();
    static int N, M;

    public static void main(String[] args) throws IOException{
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        for(int i = 1; i <=N; i++){
            numbers.add(i);
        }

        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken()) - 1;
            int to = Integer.parseInt(st.nextToken()) - 1;
            for(int j = from; to > j; j++, to--){
                Collections.swap(numbers, j, to);
            }
        }

        for(int number : numbers){
            sb.append(number).append(" ");
        }
        System.out.println(sb);
    }
}
