package lessons.lesson10;

public class MinPerimeterRectangle {
    public int solution(int N){
        int squareRoot = (int)Math.sqrt(N);
        while(N % squareRoot != 0)
            squareRoot--;
        return 2 * (N / squareRoot + squareRoot);
    }

    public static void main(String[] args) {
        MinPerimeterRectangle rectangle = new MinPerimeterRectangle();
        System.out.println(rectangle.solution(30));
        System.out.println(rectangle.solution(1));
    }
}
