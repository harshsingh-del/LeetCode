class Solution {
    public int[] maxDepthAfterSplit(String seq) {
        int n = seq.length();
        int[] result = new int[n];
        int depth = 0;
        
        for (int i = 0; i < n; i++) {
            char ch = seq.charAt(i);
            
            if (ch == '(') {
                result[i] = depth % 2;
                depth++;
            } else { 
                depth--;
                result[i] = depth % 2;
            }
        }
        
        return result;
    }
}