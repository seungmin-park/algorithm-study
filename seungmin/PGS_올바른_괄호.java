import java.util.*;

public class PGS_올바른_괄호 {
    class Solution {
        List<Character> stack = new ArrayList<>();

        boolean solution(String s) {
            boolean answer = true;
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) == '(') {
                    stack.add('(');
                } else {
                    if (stack.size() < 1) {
                        return false;
                    }
                    stack.remove(stack.size() - 1);
                }
            }
            if (stack.size() > 0) {
                return false;
            }
            return answer;
        }
    }
}
