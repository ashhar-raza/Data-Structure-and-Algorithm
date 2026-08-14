class Solution {
    public int maxProfit(int[] prices) {
        
        int mini = Integer.MAX_VALUE;
      
        int profit = 0;
        for(int i : prices)
        {
            if(i > mini)
            {
                profit += i - mini;
            }
            mini = i;
        }
        return profit;


    }
}