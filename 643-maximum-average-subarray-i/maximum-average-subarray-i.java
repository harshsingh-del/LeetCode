class Solution {
    public double findMaxAverage(int[] nums, int k) {

        int maxsum = Integer.MIN_VALUE;
        int cursum = 0;
        int windowstart = 0;
        int windowend = 0;

        while (windowend < nums.length) {

            cursum += nums[windowend];

            if (windowend >= k - 1) {
                maxsum = Math.max(maxsum, cursum);
                cursum -= nums[windowstart];
                windowstart++;
            }

            windowend++;
        }

        return maxsum * 1.0 / k;
    }
}
