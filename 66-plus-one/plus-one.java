class Solution {
    public int[] plusOne(int[] digits) {

        int i = digits.length - 1;

        int b = 1;
        while (b > 0 && i >= 0) {
            if (digits[i] == 9) {
                b++;
                digits[i] = 0;
            }
            else
            {
                digits[i]  += 1;
            }
            i--;
            b--;
        }
        if (b > 0) {
            int[] copy = new int[digits.length + 1];

            copy[0] = 1;

            System.arraycopy(digits, 0, copy, 1, digits.length);
            return copy;
        }
        return digits;

    }
}