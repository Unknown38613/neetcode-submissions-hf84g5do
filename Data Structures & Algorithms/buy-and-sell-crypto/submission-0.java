class Solution {
    public int maxProfit(int[] prices) {
        int buyPrice = prices[0];
        int maxprofit = 0;
        for(int sellPrice = 1; sellPrice < prices.length ; sellPrice++){
            int curr = prices[sellPrice];
            if(curr < buyPrice) buyPrice = curr;
            if(curr > buyPrice){
                maxprofit = Math.max(maxprofit, curr - buyPrice);
            }
        }
        return maxprofit;
    }
}
