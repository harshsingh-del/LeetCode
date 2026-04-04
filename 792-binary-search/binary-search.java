class Solution {
    static int ser(int []nums, int target, int lo, int hi){
        if(lo>hi) return -1;
        
        int mid=lo+(hi-lo)/2;
        if(nums[mid]==target) return mid;
        if(nums[mid]<target) return ser(nums, target, mid+1,hi);
        else return ser(nums,target,lo,mid-1);
    }
    public int search(int[] nums, int target) {
        return ser(nums, target,0,nums.length-1);
    }
}