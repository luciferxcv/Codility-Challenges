package lesson.timecomplexity;

public class PermMissingElem {
    public int solution(int[] A) {
        int len = A.length, tmp1 = 0, tmp2 = 0;
        for(int i = 0; i < len; i++){
            if(i != A[i] - 1){
                tmp1 = A[i];
                A[i] = 0;
                // put the element in correct position
                while(tmp1 != 0){
                    if(tmp1 == len + 1) {
                        break;
                    }else{
                        tmp2 = A[tmp1 - 1];
                        A[tmp1 - 1] = tmp1;
                        tmp1 = tmp2;
                    }
                }
            }
        }
        for(int i = 0; i < len; i++){
            if(A[i] == 0) return i+1;
        }
        return len + 1;
    }
}
