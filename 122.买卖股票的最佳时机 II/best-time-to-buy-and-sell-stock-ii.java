// 解法一 贪心算法
public int maxProfit(int[] prices) {
    int profit = 0;
    for(int i = 0; i < prices.length - 1; i++){
        int diff = prices[i + 1] - prices[i];
        if(diff > 0){
            profit += diff;
        }
    }
    return profit;
}