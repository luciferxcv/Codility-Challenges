package lessons.lesson3;

public class FrogJmp {
    public int solution(int X, int Y, int D){
        return (int)Math.ceil((Y-X)*1.0/D);
    }

    public static void main(String[] args) {
        System.out.println(new FrogJmp().solution(10, 85, 30));
    }
}
