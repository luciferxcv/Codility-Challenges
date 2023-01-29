package lessons.lesson2;

public class OddOccurrencesInArray {
    public int solution(int[] A) {
        int oddElement = 0;
        for(int i : A){
            oddElement ^= i;
        }
        return oddElement;
    }
}
