import java.io.*;
import java.util.*;

public class Boj_11507 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static Map<Character, Set<String>> cards = new LinkedHashMap<>();
    static String target;

    public static void main(String[] args) throws IOException {
        target = br.readLine();
        cards.put('P', new HashSet<>());
        cards.put('K', new HashSet<>());
        cards.put('H', new HashSet<>());
        cards.put('T', new HashSet<>());

        for(int i = 0; i < target.length() - 2; i += 3){
            String card = target.substring(i, i + 3);
            Character type = card.charAt(0);
            String numebr = card.substring(1, 3);
            if (cards.get(type).contains(numebr)) {
                System.out.println("GRESKA");
                return;
            }
            cards.get(type).add(numebr);
        }

        for(Character type : cards.keySet()){
            Set<String> c = cards.get(type);
            sb.append(13- c.size()).append(" ");
        }

        System.out.println(sb);
    }
}
