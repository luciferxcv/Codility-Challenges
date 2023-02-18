package lessons.lesson10;

public class CountFactors {
    public int solution(int N){
        int end = (int)Math.sqrt(N), count = 0;
        for(int i = 2; i <= end; i++){
            if(N%i == 0){
                count+=2;
            }
        }
        return end * end == N ? count + 1 : count + 2;
    }

    public static void main(String[] args) {
        CountFactors countFactors = new CountFactors();
        System.out.println(countFactors.solution(24));
        System.out.println(countFactors.solution(16));
        System.out.println(countFactors.solution(36));
    }
}
