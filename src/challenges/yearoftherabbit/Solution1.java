package challenges.yearoftherabbit;

public class Solution1 {
    public int solution(int[] A, int[] B){
        int len = A.length, rotateTimes = 0;
        for(int i = 0; i < len; i++){
            if(rotateTimes == len) return -1;
            int bIndex = (i - rotateTimes + len) % len;
            if(A[i] == B[bIndex]){
                rotateTimes++;
                i = -1;
            }
        }
        return rotateTimes;
    }
}
