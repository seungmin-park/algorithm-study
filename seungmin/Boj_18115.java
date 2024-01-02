import java.io.*;
import java.util.*;

public class Boj_18115 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static Deque<Integer> dq = new LinkedList<>();
    static int N;
    
    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        List<String> options = List.of(br.readLine().split(" "));

        int num = 1;
        for(int i = N - 1; i >= 0; i--){
            String opt = options.get(i);
            if(opt.equals("1")){
                dq.addFirst(num);
            }else if(opt.equals("2")){
                int temp = dq.removeFirst();
                dq.addFirst(num);
                dq.addFirst(temp);
            }else if(opt.equals("3")){
                dq.addLast(num);
            }
            num++;
        }

        dq.forEach(e -> sb.append(e).append(" "));
        
        System.out.println(sb);
    }
}