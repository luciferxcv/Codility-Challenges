package challenge.thematrix2021;

import java.util.ArrayDeque;
import java.util.Deque;

public class Solution1 {
    public int solution(int[] A){
        int sideLen = 1;
        int width = 1;
        int N = A.length;
        Deque<Integer> deque = new ArrayDeque<>();
        deque.add(0);
        int first = 0;
        for(int i = 1; i < N; i++){
            width++;
            if(A[i] > A[first]){
                while(A[deque.peekLast()] > A[i])
                    deque.pollLast();
                if(A[deque.peekLast()] < A[i])
                    deque.add(i);
            }else{
                deque.clear();
                deque.add(i);
                first = i;
            }

            if(width < A[first]){
                sideLen = Math.max(sideLen, width);
                continue;
            }
            if(width > A[first])
                width--;
            sideLen = Math.max(sideLen, width);
            deque.poll();
            if(deque.size() == 0) {
                deque.add(++i);
                width = 1;
            }else{
                width = i - first;
            }
            first = deque.peek();
        }
        return sideLen;
    }
}
