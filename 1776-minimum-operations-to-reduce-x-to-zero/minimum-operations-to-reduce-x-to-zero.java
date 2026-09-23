class Solution {

    public int minOperations(int[] nums, int x) {

        int totalSum = 0;

        for (int num : nums) {
            totalSum += num;
        }

        int target = totalSum - x;

        // We need to remove everything
        // if target == 0
        if (target == 0) {
            return nums.length;
        }

        int left = 0;
        int sum = 0;
        int maxLength = -1;

        for (int right = 0; right < nums.length; right++) {

            sum += nums[right];

            // Window sum is too large
            while (left <= right && sum > target) {
                sum -= nums[left];
                left++;
            }

            // Found a valid window
            if (sum == target) {
                maxLength = Math.max(
                    maxLength,
                    right - left + 1
                );
            }
        }

        if (maxLength == -1) {
            return -1;
        }

        return nums.length - maxLength;
    }
}