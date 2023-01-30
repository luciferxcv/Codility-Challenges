package lessons.lesson4;

import java.util.*;

public class MissingInteger {
    public int solution(int[] A) {
        Set<Integer> positiveNums = new HashSet<>();
        for(int i : A){
            if(i > 0) positiveNums.add(i);
        }
        for(int i = 1; i <= 1_000_000; i++){
            if(!positiveNums.contains(i)) return i;
        }
        return 1_000_001;
    }
}
