import java.io.*;

public class Boj_27649 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static String target;

    public static void main(String[] args) throws IOException {
        target = br.readLine();

        boolean flag = true;
        boolean andor = false;

        for (int i = 0; i < target.length(); i++) {
            char currentChar = target.charAt(i);

            if (currentChar == ' ') {
                if (!flag) {
                    sb.append(' ');
                    flag = true;
                }
            } else if (currentChar == '<' || currentChar == '>' || currentChar == '(' || currentChar == ')') {
                if (!flag) {
                    sb.append(' ').append(currentChar).append(' ');
                    flag = true;
                } else {
                    sb.append(currentChar).append(' ');
                }
            } else if (currentChar == '&' || currentChar == '|') {
                if (!flag) {
                    if (!andor) {
                        sb.append(' ').append(currentChar);
                        andor = true;
                    } else {
                        sb.append(currentChar).append(' ');
                        andor = false;
                    }
                    flag = true;
                } else {
                    if (!andor) {
                        sb.append(currentChar);
                        andor = true;
                    } else {
                        sb.append(currentChar).append(' ');
                        andor = false;
                    }
                }
            } else {
                sb.append(currentChar);
                flag = false;
            }
        }

        System.out.println(sb.toString());
    }
}
