class Solution {
    public int maxProfit(int[] prices) {
        int buy = prices[0];
        int max = 0;
        for (int i = 1; i < prices.length; i++) {
            int profit = prices[i] - buy;
            if (profit > max) max = profit;
            if (prices[i] < buy) buy = prices[i];
        }
        return max;
    }
}
