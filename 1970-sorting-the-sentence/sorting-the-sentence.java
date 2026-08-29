class Solution {
    public String sortSentence(String s) {

        int n = s.length();

        // Count number of words
        int space = 1;

        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == ' ') {
                space++;
            }
        }

        // Array to store words according to their position
        String[] words = new String[space];

        // Used to build one word
        StringBuilder w = new StringBuilder();

        for (int i = 0; i < n; i++) {

            char ch = s.charAt(i);

            // If current character is a number
            if (ch >= '0' && ch <= '9') {

                int index = ch - '0';

                words[index - 1] = w.toString();

                // Clear StringBuilder for next word
                w.setLength(0);

                continue;
            }

            // Ignore spaces
            if (ch == ' ') {
                continue;
            }

            // Add character to current word
            w.append(ch);
        }

        // Build answer
        StringBuilder ans = new StringBuilder();

        for (int i = 0; i < space; i++) {

            if (i > 0) {
                ans.append(" ");
            }

            ans.append(words[i]);
        }

        return ans.toString();
    }
}