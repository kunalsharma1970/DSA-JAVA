class Solution {
    public int tribonacci(int n) {
        int dp[]=new int[n+1];
        Arrays.fill(dp,-1);
        return fun(n,dp);
    }
    public int fun(int n,int[]dp){
        if(n<2) return n;
        if(n==2) return 1;
        if(dp[n]!=-1) return dp[n];
        int a=fun(n-1,dp);
        int b=fun(n-2,dp);
        int c=fun(n-3,dp);
        dp[n]=a+b+c;
        return a+b+c;
    }
}