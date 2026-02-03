class Solution {
    public int pivotIndex(int[] nums) {
        int n=nums.length;
        int [] pre=nums;
        pre[0]=nums[0];
        for(int i=1;i<n;i++){
            pre[i]=pre[i-1]+nums[i];

        }
        int left,right;
        for(int i=0;i<nums.length;i++){
            left=(i==0) ? 0 : pre[i-1];
            right=pre[nums.length-1]-pre[i];
            if(left==right) return i;
             }
         

        return -1;
    }
        
    }
