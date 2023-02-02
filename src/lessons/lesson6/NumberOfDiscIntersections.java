package lessons.lesson6;

//TODO: unfinished
public class NumberOfDiscIntersections {
    /**
     * O(n^2) complexity
     * @param A
     * @return
     */
    public int solution(int[] A){
        int len = A.length, total = 0;
        for(int i = len - 1; i > 0; i--){
            for(int j = i - 1; j > -1; j--){
                if(A[i] - i <= (long)A[j] + j){
                    total++;
                }
            }
        }
        return total;
    }

    public static void main(String[] args) {
        new NumberOfDiscIntersections().solution(new int[]{1, 5, 2, 1, 4, 0});
    }
}
