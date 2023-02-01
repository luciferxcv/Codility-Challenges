package lessons.lesson5;

public class CountDiv {
    public int solution(int A, int B, int K){
        if(A % K == 0)
            return (B - A) / K + 1;
        return (B - A + A % K) / K;
    }

    public static void main(String[] args){
        System.out.println(new CountDiv().solution(0, Integer.MAX_VALUE, 2));
    }
}
