import java.io.*;
import java.util.*;

public class Boj_19583 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static Set<String> in = new HashSet<>();
    static Set<String> out = new HashSet<>();
    static int ans;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        String start = st.nextToken();
        String startHour = start.split(":")[0];
        String startMinute = start.split(":")[1];
        String end = st.nextToken();
        String endHour = end.split(":")[0];
        String endMinute = end.split(":")[1];
        String streaming = st.nextToken();
        String streamingHour = streaming.split(":")[0];
        String streamingMinute = streaming.split(":")[1];

        String input;
        while ((input = br.readLine()) != null) {
            if (input.isEmpty()) {
                break;
            }
            st = new StringTokenizer(input);
            String chat = st.nextToken();
            String chatHour = chat.split(":")[0];
            String chatMinute = chat.split(":")[1];
            String nickname = st.nextToken();
            if (isBeforeOrEqualsStart(startHour, startMinute, chatHour, chatMinute, nickname)) {
                continue;
            }
            if (isBeforeEnd(endHour, endMinute, chatHour, chatMinute)) {
                continue;
            }
            isBeforeOrEqualStreaming(streamingHour, streamingMinute, chatHour, chatMinute, nickname);
        }

        for (String o : out) {
            if (in.contains(o)) {
                ans++;
            }
        }

        System.out.println(ans);
    }

    private static void isBeforeOrEqualStreaming(String streamingHour, String streamingMinute, String chatHour, String chatMinute, String nickname) {
        if (streamingHour.compareTo(chatHour) > 0) {
            out.add(nickname);
        } else if (streamingHour.compareTo(chatHour) == 0) {
            if (streamingMinute.compareTo(chatMinute) >= 0) {
                out.add(nickname);
            }
        }
    }

    private static boolean isBeforeEnd(String endHour, String endMinute, String chatHour, String chatMinute) {
        if (endHour.compareTo(chatHour) > 0) {
            return true;
        }
        if (endHour.compareTo(chatHour) == 0) {
            return endMinute.compareTo(chatMinute) > 0;
        }
        return false;
    }

    private static boolean isBeforeOrEqualsStart(String startHour, String startMinute, String chatHour, String chatMinute, String nickname) {
        if (startHour.compareTo(chatHour) > 0) {
            in.add(nickname);
            return true;

        } else if (startHour.compareTo(chatHour) == 0) {
            if (startMinute.compareTo(chatMinute) >= 0) {
                in.add(nickname);
            }
            return true;
        }
        return false;
    }
}
