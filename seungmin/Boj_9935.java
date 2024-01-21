import java.io.*;
import java.util.*;

public class Boj_9935 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static Stack<Character> stack = new Stack<>();
    static String target, regex;

    public static void main(String[] args) throws IOException {
        target = br.readLine();
        regex = br.readLine();
        int regexSize = regex.length();

        for (int i = 0; i < target.length(); i++) {
            stack.push(target.charAt(i));
            if (stack.size() >= regexSize) {
                boolean flag = true;
                for (int j = 0; j < regexSize; j++) {
                    int idx = stack.size() - regexSize + j;
                    if (stack.get(idx) != regex.charAt(j)) {
                        flag = false;
                        break;
                    }
                }

                if (flag) {
                    for (int j = 0; j < regexSize; j++) {
                        stack.pop();
                    }
                }
            }
        }

        for (char e : stack) {
            sb.append(e);
        }

        System.out.println(sb.toString().isEmpty() ? "FRULA" : sb);
    }
}
