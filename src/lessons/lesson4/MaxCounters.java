package lessons.lesson4;

public class MaxCounters {
    public int[] solution(int N, int[] A) {
        int[] counters = new int[N];
        int max1 = 0, max2 = 0;
        for(int i : A){
            if(i == N+1){
                max1 = max2;
            }else{
                if(counters[i-1] < max1){
                    counters[i-1] = max1 + 1;
                }else{
                    counters[i-1]++;
                }
                max2 = Math.max(max2, counters[i-1]);
            }
        }
        for(int i = 0; i < N; i++){
            if(counters[i] < max1) counters[i] = max1;
        }
        return counters;
    }

    public static void main(String[] args){
        for(int i : new MaxCounters().solution(5, new int[]{3, 4, 4, 6, 1, 4, 4})){
            System.out.print(i+" ");
        }
    }
}
