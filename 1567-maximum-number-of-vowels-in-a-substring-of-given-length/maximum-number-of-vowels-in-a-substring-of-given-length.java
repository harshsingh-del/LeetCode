class Solution {

    public int maxVowels(String s, int k) {
        int maxsum = 0;
        int cursum = 0;
        int windowstart = 0;

        for (int windowend = 0; windowend < s.length(); windowend++) {

            if (isVowel(s.charAt(windowend))) {
                cursum++;
            }
            if (windowend >= k - 1) {
                maxsum = Math.max(maxsum, cursum);

                if (isVowel(s.charAt(windowstart))) {
                    cursum--;
                }
                windowstart++;
            }
        }
        return maxsum;
    }

    public static boolean isVowel(char ch) {
        return ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u';
    }
}
