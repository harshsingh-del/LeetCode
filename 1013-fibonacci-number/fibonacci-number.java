class Solution {
    public int fibo(int n, int [] dp){
            if(n<=1) return n;
            if(dp[n]!=0) return dp[n];
            return fibo(n-1,dp)+fibo(n-2,dp);
    }
    public int fib(int n) {
        int [] dp = new int[n+1];
        return fibo(n,dp);
    }
}