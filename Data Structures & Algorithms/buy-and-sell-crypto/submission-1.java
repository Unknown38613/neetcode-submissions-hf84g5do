class Solution {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length < 2) return 0;

        int minPrice = prices[0];
        int maxProfit = 0;

        for (int i = 1; i < prices.length; i++) {
            int curr = prices[i];
            // Profit if we sell today using the best (lowest) buy so far
            maxProfit = Math.max(maxProfit, curr - minPrice);
            // Update the best buy for future days
            minPrice = Math.min(minPrice, curr);
        }
        return maxProfit;
    }
}