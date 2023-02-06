package lessons.lesson8;

import java.util.HashMap;
import java.util.Map;

public class Dominator {
    public int solution(int[] A){
        int len = A.length;
        if(len == 1) return 0;
        int target = len / 2;
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < len; i++){
            if(map.containsKey(A[i])){
                int count = map.get(A[i]) + 1;
                if(count > target)
                    return i;
                else
                    map.put(A[i], count);
            }else{
                map.put(A[i], 1);
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Dominator dominator = new Dominator();
        System.out.println(dominator.solution(new int[]{2,2,2,1,1,1,1,1,1,2,2,2}));
        System.out.println(dominator.solution(new int[]{}));
        System.out.println(dominator.solution(new int[]{1}));
        System.out.println(dominator.solution(new int[]{1,1,2,2,2}));
    }
}
