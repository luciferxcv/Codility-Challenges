package challenge.carolofthecode;

//TODO: unfinished
public class Solution1 {
    public int solution(String[] A) {
        int len = A.length;
        if(len == 1) return 0;
        int leftBased = 0, rightBased = 0;
        int leftJoint = A[0].charAt(1), rightJoint = A[len-1].charAt(3);
        for(int i = 1, j = len - 2; i < len; i++, j--){
            // left one based, rotate right one
            if(A[i].charAt(3) != leftJoint){
                if(A[i].charAt(1) == leftJoint){
                    leftBased += 2;
                    leftJoint = A[i].charAt(1);
                }else{
                    leftBased += 1;
                    leftJoint = A[i].charAt(0) == leftJoint ? A[i].charAt(2) : A[i].charAt(0);
                }
            }else{
                leftJoint = A[i].charAt(1);
            }
            // right one based, rotate left one
            if(A[j].charAt(1) != rightJoint){
                if(A[j].charAt(3) == rightJoint){
                    rightBased += 2;
                    rightJoint = A[j].charAt(1);
                }else{
                    rightBased += 1;
                    rightJoint = A[j].charAt(0) == rightJoint ? A[j].charAt(2) : A[j].charAt(0);
                }
            }else{
                rightJoint = A[j].charAt(3);
            }
        }
        return Math.min(leftBased, rightBased);
    }

    public static void main(String[] args){
        System.out.println(new Solution1().solution(new String[]{"rbgw","gbrw", "rwgb", "gbrw"}));

    }
}
