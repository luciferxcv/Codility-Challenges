package lessons.lesson7;

public class StoneWall {
    public int solution(int[] H){
        int len = H.length, counter = 0, top = 0;
        for(int i = 1; i < len; i++){
            while (top > -1 && H[i] < H[top]) {
                top--;
                counter++;
            }
            if(top == -1 || H[top] != H[i]){
                H[++top] = H[i];
            }
        }
        return counter + top + 1;
    }

    public static void main(String[] args) {
        StoneWall stoneWall = new StoneWall();
        System.out.println(stoneWall.solution(new int[]{8,8,5,7,9,8,7,4,8}));
    }
}
