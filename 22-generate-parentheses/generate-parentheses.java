class Solution {

    private void solve(List<String> ans ,  String curr , int n , int open , int close)
    {
        if(curr.length() == n * 2)
        {
            ans.add(curr);
            return;
        }
        if(curr.length() > n * 2)
        {
            return;
        }

        if(open < n)
        {
            solve(ans , curr + "(" , n , open + 1 , close);
        }

        if(close < open)
        {
            solve(ans , curr + ")" , n , open , close + 1);
        }
    }
    public List<String> generateParenthesis(int n) {

        List<String> ans = new ArrayList<>();
        solve(ans , "" , n , 0 , 0);
        return ans;
    }
}