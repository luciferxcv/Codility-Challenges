package lessons.lesson17;

public class NumberSolitaire {
    public int solution(int[] A){
        int len = A.length;
        int[] fn = new int[7];
        fn[0] = A[0];
        for(int i = 1; i < len; i++){
            int maxValue = Integer.MIN_VALUE;
            for(int j = 1; j < 7 && i - j > -1; j++){
                maxValue = Math.max(fn[(i-j) % 7], maxValue);
            }
            fn[i % 7] = maxValue + A[i];
        }
        return fn[(len - 1) % 7];
    }

    public static void main(String[] args) {
        NumberSolitaire numberSolitaire = new NumberSolitaire();
        System.out.println(numberSolitaire.solution(new int[]{1, -2, 0, 9, -1, -2}));//8
        System.out.println(numberSolitaire.solution(new int[]{-2, 5, 1}));//4
        System.out.println(numberSolitaire.solution(new int[]{-4, -10, -7}));//-11
    }
}
