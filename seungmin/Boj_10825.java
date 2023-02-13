import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 정렬 O(NlogN)
 * input: 최대 10만
 * 최악의 경우 10만 * 5 = 50만
 * 별도의 객체 선언 -> 객체 정렬 -> stable sort
 * 점수의 범위 1 ~ 100 -> int
 */
public class Boj_10825 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static Student[] students;
    static int N;

    static class Student implements Comparable<Student> {
        String name;
        int kor, eng, math;

        Student(String name, int kor, int eng, int math) {
            this.name = name;
            this.kor = kor;
            this.eng = eng;
            this.math = math;
        }


        @Override
        public int compareTo(Student s) {
            // 모든 점수가 같으면 이름이 사전 순으로 증가하는 순서로
            if (kor == s.kor && eng == s.eng && math == s.math) {
                return name.compareTo(s.name);
            }
            //국어 점수와 영어 점수가 같다면 수학 점수가 감소하는 순서로
            if (kor == s.kor && eng == s.eng) {
                return s.math - math;
            }
            // 국어 점수가 같으면 영어 점수가 증가하는 순서로
            if (kor == s.kor) {
                return eng - s.eng;
            }
            // 국어 점수가 감소하는 순서로
            return s.kor - kor;
        }
    }

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        students = new Student[N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            String name = st.nextToken();
            int kor = Integer.parseInt(st.nextToken());
            int eng= Integer.parseInt(st.nextToken());
            int math = Integer.parseInt(st.nextToken());
            students[i] = new Student(name, kor, eng, math);
        }

        Arrays.sort(students);

        for (Student student : students) {
            sb.append(student.name).append("\n");
        }

        System.out.println(sb);
    }
}
