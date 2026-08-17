class Solution {

    private int[][] dp;
    private int[] prefix;

    private int getSum(int l, int r) {
        return prefix[r + 1] - prefix[l];
    }

    private int solve(int left, int right) {

        if (left == right) {
            return 0;
        }

        if (dp[left][right] != -1) {
            return dp[left][right];
        }

        int ans = 0;

        for (int k = left; k < right; k++) {

            int sumL = getSum(left, k);
            int sumR = getSum(k + 1, right);

            if (sumL < sumR) {
                ans = Math.max(ans, sumL + solve(left, k));
            } else if (sumL > sumR) {
                ans = Math.max(ans, sumR + solve(k + 1, right));
            } else {
                ans = Math.max(
                        ans,
                        Math.max(
                                sumL + solve(left, k),
                                sumR + solve(k + 1, right)
                        )
                );
            }
        }

        return dp[left][right] = ans;
    }

    public int stoneGameV(int[] stoneValue) {

        int n = stoneValue.length;

        dp = new int[n][n];

        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], -1);
        }

        prefix = new int[n + 1];

        for (int i = 0; i < n; i++) {
            prefix[i + 1] = prefix[i] + stoneValue[i];
        }

        return solve(0, n - 1);
    }
}