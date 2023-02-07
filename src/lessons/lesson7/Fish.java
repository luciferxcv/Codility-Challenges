package lessons.lesson7;

public class Fish {
    public int solution(int[] A, int[] B){
        int len = A.length;
        int i = -1;
        int upstreamTotal = 0, downstreamTotal = 0;
        for(int j = 0; j < len; j++){
            if(B[j] == 1){
                A[++i] = A[j];
                downstreamTotal++;
            }else{
                while(i > -1 && A[i] < A[j]){
                    i--;
                    downstreamTotal--;
                }
                if(i == -1) downstreamTotal++;
            }
        }
        return upstreamTotal + downstreamTotal;
    }

    public static void main(String[] args) {
        Fish fish = new Fish();
        System.out.println(fish.solution(new int[]{4, 3, 2, 1, 5}, new int[]{0, 1, 0, 0, 0}));
        System.out.println(fish.solution(new int[]{4, 3}, new int[]{0, 1}));
    }
}
