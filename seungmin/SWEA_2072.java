import java.io.*;
import java.util.*;

public class SWEA_2072 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static int T;

    public static void main(String[] args) throws IOException {
        T = Integer.parseInt(br.readLine());
        for(int t= 1; t<= T; t++){
            st = new StringTokenizer(br.readLine());
            int sum = 0;
            while(st.hasMoreTokens()){
                int now = Integer.parseInt(st.nextToken());
                if(now % 2 ==0){
                    continue;
                }
                sum += now;
            }
            sb.append("#").append(t).append(" ").append(sum).append("\n");
        }

        System.out.println(sb);
    }
}
