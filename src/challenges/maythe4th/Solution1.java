package challenges.maythe4th;

import java.util.HashSet;
import java.util.Set;

public class Solution1 {
    public int solution(int[] A, int L, int R){
        Set<Integer> lPlaced = new HashSet<>(), rPlaced = new HashSet<>();
        for(int i : A){
            if(i < L && !lPlaced.contains(i)){
                lPlaced.add(i);
            }else if(i > R && !rPlaced.contains(i)){
                rPlaced.add(i);
            }
        }
        return lPlaced.size() + rPlaced.size();
    }
}
