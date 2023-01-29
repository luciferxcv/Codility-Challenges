package lessons.lesson1;

public class BinaryGap {
    public int solution(int N) {
        boolean hasBorder = false;
        int mask = 1, max = 0, current = 0;
        int limit = 1 << 31;
        while(mask < N && mask != limit){
            if((mask & N) != 0){
                if(!hasBorder) {
                    current = 0;
                    hasBorder = true;
                }else{
                    max = Math.max(max, current);
                    current = 0;
                }
            }else
                current++;
            mask = mask << 1;
        }
        return max;
    }

    public static void main(String[] args){
        System.out.println(new BinaryGap().solution(1073741825));
    }
}
