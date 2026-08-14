class Solution {
    public int maximumLengthSubstring(String s) {
        
        int freq[] = new int[26];
        int ans  = 0;
        int start = 0;
        for(int i = 0 ; i < s.length() ; i++)
        {
            int index = s.charAt(i) - 'a';

            freq[index]++; 
            
            if(freq[index] > 2)
            {
                while(freq[index] > 2)
                {
                    int j = s.charAt(start) - 'a';
                    freq[j]--;
                    start++;
                }
            }
    

            ans = Math.max(i - start + 1 , ans);
        }

        return ans;
    }
}