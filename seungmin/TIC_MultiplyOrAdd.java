import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class TIC_MultiplyOrAdd {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static String number;

    public static void main(String[] args) throws IOException {
        number = br.readLine();

        int result = number.charAt(0) - 48;
        for (int i = 1; i < number.length(); i++) {
            int currentNumber = number.charAt(i) - 48;
            if (currentNumber <= 1 || result <= 1) {
                result += currentNumber;
                continue;
            }
            result *= currentNumber;
        }

        System.out.println(result);
    }
}
