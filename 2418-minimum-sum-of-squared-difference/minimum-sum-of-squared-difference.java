
class Solution {
    public long minSumSquareDiff(int[] nums1, int[] nums2, int k1, int k2) {
        int n = nums1.length;
        long[] diff = new long[n];

        long totalOperations = (long) k1 + k2;
        long maxDiff = 0;

        for (int i = 0; i < n; i++) {
            diff[i] = Math.abs(nums1[i] - nums2[i]);
            maxDiff = Math.max(maxDiff, diff[i]);
        }

        long low = 0;
        long high = maxDiff;

        // Find the smallest maximum difference achievable
        while (low < high) {
            long mid = low + (high - low) / 2;
            long operations = 0;

            for (long d : diff) {
                if (d > mid) {
                    operations += d - mid;
                }
            }

            if (operations <= totalOperations) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }

        long limit = low;
        long remaining = totalOperations;
        long answer = 0;

        // Reduce every difference greater than the limit
        for (int i = 0; i < n; i++) {
            if (diff[i] > limit) {
                remaining -= diff[i] - limit;
                diff[i] = limit;
            }
        }

        // Use remaining operations to reduce differences at the limit
        for (int i = 0; i < n && remaining > 0; i++) {
            if (diff[i] == limit && diff[i] > 0) {
                diff[i]--;
                remaining--;
            }
        }

        // Calculate the sum of squared differences
        for (long d : diff) {
            answer += d * d;
        }

        return answer;
    }
}
