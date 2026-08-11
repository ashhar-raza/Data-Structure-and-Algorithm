class Solution {
    public int maxProfit(int[] prices) {
        int i = prices.length - 1;
        int maxi = prices[i];
        int result = 0;

        while(i >= 0)
        {
            maxi = Math.max(maxi , prices[i]);

            result = Math.max(result , maxi - prices[i]);
            i--;
        }
    return result;
    }
}