import java.io.*;
import java.util.*;

public class Boj_17413 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static Stack<Character> stack = new Stack<>();
    static String input;

    public static void main(String[] args) throws IOException {
        input = br.readLine();

        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) == '<') {
                while (!stack.isEmpty()) {
                    sb.append(stack.pop());
                }
                while (input.charAt(i) != '>') {
                    sb.append(input.charAt(i++));
                }
                sb.append('>');
            } else if (input.charAt(i) == ' ') {
                while (!stack.isEmpty()) {
                    sb.append(stack.pop());
                }
                sb.append(' ');
            } else {
                stack.push(input.charAt(i));
            }
        }
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }

        System.out.println(sb);
    }
}
