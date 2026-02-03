class Solution {
    public int largestAltitude(int[] gain) {
        int maxalt=0;
        int curr=0;
        for(int i=0;i<gain.length;i++){
           curr+= gain[i];
            maxalt=Math.max(maxalt,curr);            
        }
        return maxalt;
        
    }
}