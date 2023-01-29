package lessons.lesson4;

import java.util.HashSet;
import java.util.Set;

public class PermCheck {
    public int solution(int[] A) {
        Set<Integer> itemSet = new HashSet<>();
        int len = A.length;
        for(int i : A){
            if(i > len) return 0;
            itemSet.add(i);
        }
        return itemSet.size() == len ? 1 : 0;
    }
}
