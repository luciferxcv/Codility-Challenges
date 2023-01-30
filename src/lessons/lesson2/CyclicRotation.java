package lessons.lesson2;

public class CyclicRotation {
    /**
     * use extra space
     */
    public int[] solution1(int[] A, int K) {
        int len = A.length;
        if(len < 2) return A;
        K = K % len;
        if(K == 0) return A;
        int[] result = new int[len];
        for(int i = 0; i < len; i++){
            result[(i+K)%len] = A[i];
        }
        return result;
    }

    /**
     * in-place algorithm
     */
    public int[] solution2(int[] A, int K) {
        int len = A.length;
        if(len > 1){
            K = K % len;
            if(K > 0) {
                int tmp1, tmp2, nextIndex, times = 0;
                for(int i = 0; i < len && times < len; i++){
                    nextIndex = (i + K) % len;
                    tmp1 = A[i];
                    A[i] = 1001;
                    while(tmp1 != 1001){
                        tmp2 = A[nextIndex];
                        A[nextIndex] = tmp1;
                        tmp1 = tmp2;
                        nextIndex = (nextIndex + K) % len;
                        times++;
                    }
                }
            }
        }
        return A;
    }

    public static void main(String[] args){
        for(int i : new CyclicRotation().solution1(new int[]{1,2,3,4,5,6}, 9)){
            System.out.print(i);
        }
        System.out.println();
        for(int i : new CyclicRotation().solution2(new int[]{1,2,3,4,5,6}, 9)){
            System.out.print(i);
        }
    }
}
