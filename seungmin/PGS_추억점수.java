import java.util.*;

public class PGS_추억점수 {
    static class Solution {
        Map<String, Integer> missingPoint = new HashMap<>();

        public int[] solution(String[] name, int[] yearning, String[][] photo) {
            init(name, yearning);
            return calcPhotoPoint(photo);
        }

        private void init(String[] name, int[] yearning) {
            for (int idx = 0; idx < name.length; idx++) {
                missingPoint.put(name[idx], yearning[idx]);
            }
        }

        private int[] calcPhotoPoint(String[][] photo) {
            int[] points = new int[photo.length];
            for (int col = 0; col < photo.length; col++) {
                int point = 0;
                for (int row = 0; row < photo[col].length; row++) {
                    point += missingPoint.getOrDefault(photo[col][row], 0);
                }
                points[col] = point;
            }

            return points;
        }
    }
}
