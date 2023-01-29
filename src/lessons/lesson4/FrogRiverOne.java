package lessons.lesson4;

import java.util.HashSet;
import java.util.Set;

public class FrogRiverOne {
    public int solution(int X, int[] A) {
        Set<Integer> positions = new HashSet<>();
        int second = 0;
        for(int i : A){
            if(i <= X){
                positions.add(i);
            }
            if(positions.size() == X)
                return second;
            second++;
        }
        return -1;
    }
}
