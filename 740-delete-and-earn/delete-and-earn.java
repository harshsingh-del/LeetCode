class Solution {
    public int deleteAndEarn(int[] nums) {
        int max = 0;
        for (int num : nums) {
            max = Math.max(max, num);
        }
        int[] sum = new int[max + 1];
        for (int num : nums) {
            sum[num] += num;
        }
        int[] dp = new int[max + 1];
        Arrays.fill(dp, -1);
        return helper(max, sum, dp);
    }

    static int helper(int i, int[] sum, int[] dp) {
        if (i <= 0) return 0;
        if (dp[i] != -1) return dp[i];
        int skip = helper(i - 1, sum, dp);
        int take = sum[i] + helper(i - 2, sum, dp);
        dp[i] = Math.max(skip, take);
        return dp[i];
    }
}