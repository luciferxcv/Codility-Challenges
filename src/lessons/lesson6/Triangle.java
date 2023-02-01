package lessons.lesson6;

import java.util.Arrays;

public class Triangle {
    public int solution(int[] A) {
        int len = A.length;
        if (len < 3) return 0;
        Arrays.sort(A);
        for (int i = 0, j = 1, k = 2; k < len; i++, j++, k++) {
            if ((long)A[i] + A[j] > A[k]) return 1;
        }
        return 0;
    }

    public static void main(String[] args) {
        System.out.println(new Triangle().solution(new int[]{Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE}));
    }
}
