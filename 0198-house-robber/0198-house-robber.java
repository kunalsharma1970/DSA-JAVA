class Solution {
    public int max=Integer.MIN_VALUE;
    public int rob(int[] nums) {
        int []dp=new int[nums.length];
        Arrays.fill(dp,-1);
        return fun(nums,dp,0);
    }
    public int fun(int []nums,int[]dp,int i){
        if(i>=nums.length){
            return 0;
        }
        if(dp[i]!=-1) return dp[i];
        int skip=fun(nums,dp,i+1);
        int take=fun(nums,dp,i+2) + nums[i];
        return dp[i]=Math.max(skip,take);
        
    }
}