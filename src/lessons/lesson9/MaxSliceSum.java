package lessons.lesson9;

public class MaxSliceSum {
    public int solution(int[] A){
        int len = A.length;
        int maxSum = A[0];
        int currentSum = A[0];
        for(int i = 1; i < len; i++){
            maxSum = Math.max(currentSum, maxSum);
            if(currentSum + A[i] <= 0 || currentSum < 0){
                currentSum = A[i];
            }else{
                currentSum += A[i];
            }
        }
        return Math.max(maxSum, currentSum);
    }

    public static void main(String[] args) {
        MaxSliceSum maxSliceSum = new MaxSliceSum();
        System.out.println(maxSliceSum.solution(new int[]{-5,2,3}));
        System.out.println(maxSliceSum.solution(new int[]{-1,2,3}));
        System.out.println(maxSliceSum.solution(new int[]{2,-1,3}));
        System.out.println(maxSliceSum.solution(new int[]{2,-3,3}));
        System.out.println(maxSliceSum.solution(new int[]{-2,-3,-1}));
        System.out.println(maxSliceSum.solution(new int[]{1,3,-2}));
        System.out.println(maxSliceSum.solution(new int[]{-2,3,-2}));
    }
}
