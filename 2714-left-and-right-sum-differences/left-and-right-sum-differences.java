class Solution {
    public int[] leftRightDifference(int[] nums) {
        int n=nums.length;
        int[] pre = new int[n];
        int[] suf = new int[n];
        int[] arr = new int[n];
        pre[0]=nums[0];
        for(int i=1;i<n;i++){
            pre[i]=pre[i-1]+nums[i];
        }
        suf[n - 1] = nums[n - 1];
        for(int i=n-2;i>=0;i--){
            suf[i]=suf[i+1]+nums[i];
        }
        for(int i=0;i<n;i++){
            arr[i]=pre[i]-suf[i];
            if(arr[i]<0){
                arr[i]=arr[i]*(-1);
            }
        }
        return arr;
    }
}