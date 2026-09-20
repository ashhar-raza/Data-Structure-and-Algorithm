class Solution {
    public int reverseDegree(String s) {
        
        int ans = 0;
        int[] val = new int[26];
        for(int i = 0 ; i < 26 ; i++)
        {
            val[i] = 26 - i;
            
        }
        for(int i = 0 ; i < s.length() ; i++)
        {
            char ch = s.charAt(i);
            ans = (val[ch - 'a'] * (i+1)) + ans;
        }

        return ans;

    }
}