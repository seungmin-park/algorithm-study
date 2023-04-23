import java.io.*;
import java.util.*;

public class Boj_4949 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static List<Character> stack;
    static String str;

    public static void main(String[] args) throws IOException {
        while (!(str = br.readLine()).equals(".")) {
            int idx = 0;
            stack = new ArrayList<>();
            boolean flag = false;
            while (str.charAt(idx) != '.') {
                if (str.charAt(idx) == ']') {
                    if (stack.size() == 0 || stack.get(stack.size() - 1) != '[') {
                        flag = true;
                        break;
                    }
                    stack.remove(stack.size() - 1);
                } else if (str.charAt(idx) == ')') {
                    if (stack.size() == 0 || stack.get(stack.size() - 1) != '(') {
                        flag = true;
                        break;
                    }
                    stack.remove(stack.size() - 1);
                } else if (str.charAt(idx) == '(') {
                    stack.add('(');
                } else if (str.charAt(idx) == '[') {
                    stack.add('[');
                }
                idx++;
            }
            if (flag)
                sb.append("no").append("\n");
            else if (stack.size() == 0)
                sb.append("yes").append("\n");
            else
                sb.append("no").append("\n");
        }

        System.out.println(sb);
    }
}
