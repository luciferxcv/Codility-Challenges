package challenges.yearofthetiger;

import java.util.*;

public class Solution1 {
    public int solution(String[] T) {
        int max = 0;
        Map<String, Integer> countMap = new HashMap<>();
        for(String s : T){
            // original
            max = computeMax(countMap, s, max);
            // swap top two
            String swapTop = String.valueOf(new char[]{s.charAt(1), s.charAt(0), s.charAt(2)});
            if(!s.equals(swapTop)){
                max = computeMax(countMap, swapTop, max);
            }
            // swap bottom two
            String swapBottom = String.valueOf(new char[]{s.charAt(0), s.charAt(2), s.charAt(1)});
            if(!s.equals(swapBottom) && !swapTop.equals(swapBottom)){
                max = computeMax(countMap, swapBottom, max);
            }
        }
        return max;
    }

    private int computeMax(Map<String, Integer> countMap, String s, int max){
        int total = 1;
        if(countMap.containsKey(s)){
            total = countMap.get(s) + 1;
        }
        countMap.put(s, total);
        return total > max ? total : max;
    }
}
