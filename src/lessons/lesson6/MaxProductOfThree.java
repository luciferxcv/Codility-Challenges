package lessons.lesson6;

public class MaxProductOfThree {
    public int solution(int[] A){
        int[] maxNums = new int[3];
        maxNums[0] = maxNums[1] = maxNums[2] = Integer.MIN_VALUE;
        int[] minNegativeNums = new int[2];
        for(int i : A){
            if(i > maxNums[2]){
                maxNums[0] = maxNums[1];
                maxNums[1] = maxNums[2];
                maxNums[2] = i;
            }else if(i > maxNums[1]){
                maxNums[0] = maxNums[1];
                maxNums[1] = i;
            }else if(i > maxNums[0]){
                maxNums[0] = i;
            }
            if(i < 0){
                if(i < minNegativeNums[0]){
                    minNegativeNums[1] = minNegativeNums[0];
                    minNegativeNums[0] = i;
                }else if(i < minNegativeNums[1]){
                    minNegativeNums[1] = i;
                }
            }
        }
        return Math.max(maxNums[0] * maxNums[1] * maxNums[2],
                minNegativeNums[0] * minNegativeNums[1] * maxNums[2]);
    }

    public static void main(String[] args) {
        System.out.println(new MaxProductOfThree().solution(new int[]{-100, -90, -80, -20, -3, -2}));
    }
}
