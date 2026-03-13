class Solution {
    public int splitArray(int[] nums, int k) {
        int low = 0;
        int high = 0;
        int ans = 0;
        for (int i : nums){
            low = Math.max(i,low);
            high += i;
        }
        while (low<= high){
            int mid = low + (high-low)/2;
            int count = 1;
            int sum = 0;
            for (int i :nums){
                if (sum +i > mid){
                    count++;
                    sum = i;
                }else{
                    sum += i;
                }
            }
            if (count <=k){
                ans = mid;
                high = mid-1;
            }else low = mid+1;
        }
        return ans;
    }
}