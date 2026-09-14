class Solution {
    public int climbStairs(int n) {
        int []dp=new int[n+1];
        Arrays.fill(dp,-1);
        return fun(n,dp);
    }
    public int fun(int n,int[]dp){
        if(n<=2) return n;
        if(dp[n]!=-1) return dp[n];
        int a=fun(n-1,dp);
        int b=fun(n-2,dp);
        return dp[n]=a+b;
    }
}