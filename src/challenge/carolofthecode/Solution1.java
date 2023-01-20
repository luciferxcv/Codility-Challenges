package challenge.carolofthecode;

//TODO: unfinished
public class Solution1 {
    public int solution(String[] A) {
        if(A.length == 1) return 0;
        int startIndex = 0, curIndex = 0, maxLen = 1, curLen = 1;
        for(int i = 1; i < A.length; i++){
            if(A[i-1].charAt(1) == A[i].charAt(3)){
                if(maxLen < ++curLen){
                    maxLen = curLen;
                    startIndex = curIndex;
                }
            }else{
                curIndex = i;
                curLen = 1;
            }
        }
        int result = 0, oppositeChar;
        if(startIndex - 1 > -1){
            oppositeChar = A[startIndex].charAt(3);
            for(int i = startIndex - 1; i > -1; i--){
                if(A[i].charAt(1) == oppositeChar) {
                    oppositeChar = A[i].charAt(3);
                    continue;
                }
                if(A[i].charAt(3) == oppositeChar){
                    result += 2;
                    oppositeChar = A[i].charAt(1);
                }else{
                    result += 1;
                    oppositeChar = A[i].charAt(0) == oppositeChar ? A[i].charAt(2) : A[i].charAt(0);
                }
            }
        }
        if(startIndex + maxLen < A.length){
            oppositeChar = A[startIndex + maxLen - 1].charAt(1);
            for(int i = startIndex + maxLen; i < A.length; i++){
                if(oppositeChar == A[i].charAt(3)) {
                    oppositeChar = A[i].charAt(1);
                    continue;
                }
                if(oppositeChar == A[i].charAt(1)){
                    result += 2;
                    oppositeChar = A[i].charAt(3);
                }else{
                    result += 1;
                    oppositeChar = A[i].charAt(0) == oppositeChar ? A[i].charAt(2) : A[i].charAt(0);
                }
            }
        }
        return result;
    }

    public static void main(String[] args){
        System.out.println(new Solution1().solution(new String[]{"0123", "3120", "2301"}));

    }
}
