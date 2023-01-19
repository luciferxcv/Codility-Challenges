package challenge.carolofthecode;

//TODO: unfinished
public class Solution1 {
    public int solution(String[] A) {
        if(A.length == 1) return 0;
        int startIndex = 0, curIndex = 0, maxLen = 0, curLen = 0;
        for(int i = 1; i < A.length; i++){
            if(A[i-1].charAt(1) == A[i].charAt(3)){
                if(maxLen < ++curLen){
                    maxLen = curLen;
                    startIndex = curIndex;
                }
            }else{
                curIndex = i;
                curLen = 0;
            }
        }
        int result = 0;
        for(int i = startIndex - 1; i > -1; i--){
            if(A[i].charAt(1) == A[i+1].charAt(3)) continue;
            result += A[i].charAt(3) == A[i+1].charAt(3) ? 2 : 1;
        }
        for(int i = startIndex + maxLen; i < A.length; i++){
            if(A[i-1].charAt(1) == A[i].charAt(3)) continue;
            result += A[i-1].charAt(3) == A[i].charAt(3) ? 2 : 1;
        }
        return result;
    }
}
