class Solution {
    public int binaryGap(int n) {
        int prev = -1;       
        int maxGap = 0;
        int position = 0;

        while (n > 0) {
            if ((n & 1) == 1) {         
                if (prev != -1) {
                    maxGap = Math.max(maxGap, position - prev);
                }
                prev = position;
            }
            n >>= 1;                 
            position++;
        }

        return maxGap;
    }
}