package lessons.lesson8;

import java.util.HashMap;
import java.util.Map;

public class EquiLeader {
    public int solution(int[] A){
        int len = A.length;
        if(len == 1) return 0;
        int target = len / 2;
        Map<Integer, Integer> map = new HashMap<>();
        int leader = Integer.MIN_VALUE, totalOfLeader = 0;
        for(int i = 0; i < len; i++){
            if(map.containsKey(A[i])){
                int count = map.get(A[i]) + 1;
                if(count > target)
                    leader = A[i];
                map.put(A[i], count);
            }else{
                map.put(A[i], 1);
            }
        }
        if(leader == Integer.MIN_VALUE) return 0;
        totalOfLeader = map.get(leader);
        int totalOfEquiLeader = 0, leftEquiLeader = 0;
        for(int i = 0; i < len; i++){
            if(A[i] == leader){
                leftEquiLeader++;
            }
            if(leftEquiLeader > (i+1)/2 && totalOfLeader-leftEquiLeader > (len - i - 1)/2){
                totalOfEquiLeader++;
            }
        }
        return totalOfEquiLeader;
    }
}
