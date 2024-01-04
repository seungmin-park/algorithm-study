import java.io.*;
import java.util.*;

public class Boj_9322 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb =  new StringBuilder();
    static StringTokenizer st;
    static int T, N;

    public static void main(String[] args) throws IOException {
        T = Integer.parseInt(br.readLine());
        for(int t =1; t <= T; t++){
            N = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());
            List<String> firstSecurity = new ArrayList<>();
            for(int i = 1; i <= N; i++){
                firstSecurity.add(st.nextToken());
            }

            st = new StringTokenizer(br.readLine());
            List<String> secondSecurity = new ArrayList<>();
            for(int i = 1; i <= N; i++){
                secondSecurity.add(st.nextToken());
            }

            st = new StringTokenizer(br.readLine());
            List<String> security = new ArrayList<>();
            for(int i = 1; i <= N; i++){
                security.add(st.nextToken());
            }

            String[] normal = new String[N];
            for(int i = 0; i < N; i++){
                for(int j = 0; j < N; j++){
                    if(firstSecurity.get(i).equals(secondSecurity.get(j))){
                        normal[i] = security.get(j);
                        break;
                    }
                }
            }

            for(String n : normal){
                sb.append(n).append(" ");
            }

            sb.append("\n");
        }

        System.out.println(sb);
    }
}