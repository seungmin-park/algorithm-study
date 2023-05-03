public class PGS_다음_큰_숫자 {
    class Solution {
        public int solution(int n) {
            int answer = n;
            int nOneCnt = 0;
            int nextOneCnt = 0;
            while(n > 0){
                if(n % 2 == 1) {
                    nOneCnt++;
                }
                n /= 2;
            }
            
            do{
                answer++;
                int next = answer;
                nextOneCnt = 0;
                while(next > 0){
                if(next % 2 == 1) {
                    nextOneCnt++;
                }
                next /= 2;
            }
            }
            while(nextOneCnt != nOneCnt);
            return answer;
        }
    }
}
