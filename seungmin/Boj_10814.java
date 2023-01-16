import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Boj_10814 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    static int N;

    static class User implements Comparable<User>{
        private int age;
        private String username;

        public User(int age, String username) {
            this.age = age;
            this.username = username;
        }

        @Override
        public int compareTo(User user) {
            return this.age - user.age;
        }
    }

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        User[] users = new User[N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            users[i] = new User(Integer.parseInt(st.nextToken()), st.nextToken());
        }

        Arrays.sort(users);

        for (User user : users) {
            sb.append(user.age)
                    .append(" ")
                    .append(user.username)
                    .append("\n");
        }

        System.out.print(sb);
    }
}
