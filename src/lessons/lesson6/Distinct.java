package lessons.lesson6;

import java.util.HashSet;
import java.util.Set;

public class Distinct {
    public int solution(int[] A){
        Set<Integer> distinctNums = new HashSet<>();
        for(int i : A){
            distinctNums.add(i);
        }
        return distinctNums.size();
    }
}
