package lessons.lesson3;

public class TapeEquilibrium {
    public int solution(int[] A){
        int len = A.length, min = Integer.MAX_VALUE;
        for(int i = 1; i < len; i++){
            A[i] += A[i-1];
        }
        for(int i = 0; i < len - 1; i++){
            int diff = Math.abs(2 * A[i] - A[len-1]);
            if(diff < min){
                min = diff;
            }
        }
        return min;
    }
}
