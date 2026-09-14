class Solution {
    public int rob(int[] nums) {
        if(nums.length==1) return nums[0];
        int []dp=new int[nums.length];
        Arrays.fill(dp,-1);
        int []dp1=new int[nums.length];
        Arrays.fill(dp1,-1);
        return Math.max(fun(nums,dp,1),fun1(nums,dp1,nums.length-2));
    }
    public int fun(int[]nums,int[]dp,int i){
        if(i>=nums.length) return 0;
        if(dp[i]!=-1) return dp[i];
        int skip=fun(nums,dp,i+1);
        int take=fun(nums,dp,i+2) + nums[i];
        return dp[i]=Math.max(skip,take);
    }
    public int fun1(int[]nums,int[]dp1,int i){
        if(i<0) return 0;
        if(dp1[i]!=-1) return dp1[i];
        int skip=fun1(nums,dp1,i-1);
        int take=fun1(nums,dp1,i-2) +nums[i];
        return dp1[i]=Math.max(skip,take);
    }
}