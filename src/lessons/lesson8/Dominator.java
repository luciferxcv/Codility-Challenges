package lessons.lesson8;

import java.util.HashMap;
import java.util.Map;

public class Dominator {
    public int solution(int[] A){
        int len = A.length;
        if(len == 0) return -1;
        int max = 1;
        int index = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < len; i++){
            if(map.containsKey(A[i])){
                int count = map.get(A[i]) + 1;
                map.put(A[i], count);
                if(count > max){
                    max = count;
                    index = i;
                }
            }else{
                map.put(A[i], 1);
            }
        }
        return max > len / 2 ? index : -1;
    }

    public static void main(String[] args) {
        System.out.println(new Dominator().solution(new int[]{2,2,2,1,1,1,1,1,1,2,2,2}));
    }
}
