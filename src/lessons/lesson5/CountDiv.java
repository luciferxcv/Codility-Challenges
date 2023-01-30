package lessons.lesson5;

public class CountDiv {
    //TODO: unfinished
    public int solution(int A, int B, int K){
        if(K > B) return 0;
        if(K == 1) return B - A + 1;
        int next = A % K == 0 ? A : K - (A % K) + A;
        return (int)Math.ceil((B - next)*1.0/K);
    }

    public static void main(String[] args){
        System.out.println(new CountDiv().solution(100, 123_000_000, 2));
    }
}
