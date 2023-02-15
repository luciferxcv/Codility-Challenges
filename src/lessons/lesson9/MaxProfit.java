package lessons.lesson9;

public class MaxProfit {
    public int solution(int[] A) {
        int buy = Integer.MAX_VALUE, profit = 0;
        for(int price : A){
            if(price < buy){
                buy = price;
            }else{
                profit = Math.max(profit, price - buy);
            }
        }
        return profit;
    }

    public static void main(String[] args) {
        MaxProfit maxProfit = new MaxProfit();
        System.out.println(maxProfit.solution(new int[]{}));
        System.out.println(maxProfit.solution(new int[]{1}));
        System.out.println(maxProfit.solution(new int[]{1,2}));
        System.out.println(maxProfit.solution(new int[]{2,1}));
        System.out.println(maxProfit.solution(new int[]{5,6,10,2,6}));
    }
}
