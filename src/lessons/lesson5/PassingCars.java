package lessons.lesson5;

public class PassingCars {
    public int solution(int[] A){
        int q = 0, pairs = 0;
        for(int i = A.length - 1; i > -1; i--){
            if(A[i]==0) {
                pairs += q;
                if(pairs > 1_000_000_000)
                    return -1;
            }else
                q++;
        }
        return pairs;
    }

    public static void main(String[] args){
        System.out.println(new PassingCars().solution(new int[]{0,1,0,0,1,1,1,0,1,0,1,0,0}));
    }
}
